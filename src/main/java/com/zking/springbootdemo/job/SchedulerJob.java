package com.zking.springbootdemo.job;

import com.zking.springbootdemo.model.ScheduleTrigger;
import com.zking.springbootdemo.model.ScheduleTriggerParam;
import com.zking.springbootdemo.service.IScheduleTriggerService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

import static java.lang.Class.forName;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * 计划任务扫描程序
 * @author Administrator
 * @create 2019-12-2313:21
 */
@Configuration
public class SchedulerJob {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private Scheduler scheduler;

    @Resource
    private IScheduleTriggerService scheduleTriggerService;


    /**
     * 计划任务扫描程序，用于定时监控数据库中定义的计划任务配置， 并将配置的
     * 计划任务注册到quartz中。
     *
     * @throws SchedulerException
     * @throws ClassNotFoundException
     */
    @Scheduled(cron = "0 24 16 * * ?")
    public void run() throws SchedulerException, ClassNotFoundException {
        logger.info("@@ 计划任务扫描程序启动 ... ");

        //获取数据库中注册的所有job任务
        List<ScheduleTrigger> scheduleTriggers = scheduleTriggerService.queryAll();

        if(ObjectUtils.isEmpty(scheduleTriggers)) {
            logger.info("当前没有配置计划任务");
            return;
        }

        //遍历注册在数据库中的计划任务配置
        for(ScheduleTrigger job: scheduleTriggers) {
            JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());

            if(scheduler.checkExists(jobKey)) {
                handleRegistedInQzJob(job, jobKey);
            } else {
                registJobToQz(job);
            }
        }

    }


    /**
     * <p>将job注册到Quartz中</p>
     * <u>
     *     <li>如果数据库中配置的job为禁用状态则不需要注册</li>
     *     <li>如果数据库中为job配置了对应的参数，则需要将参数注册到Quartz的job中</li>
     * </u>
     *
     * @param job 数据库中配置到job信息
     * @throws ClassNotFoundException
     * @throws SchedulerException
     */
    private void registJobToQz(ScheduleTrigger job) throws ClassNotFoundException, SchedulerException {

        //如果是数据库中配置的是禁止状态则不需要注册，直接跳过即可
        if("0".equals(job.getStatus())) {
            return;
        }

        Class<? extends Job> jobClass = (Class<? extends Job>) forName(job.getJobName());
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(job.getJobName(), job.getJobGroup())
                .build();

        //如果为job配置了参数则处理参数
        if(!ObjectUtils.isEmpty(job.getParamList())) {
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            for(ScheduleTriggerParam p: job.getParamList()) {
                jobDataMap.put(p.getName(), p.getValue());
            }
        }

        Trigger trigger = newTrigger()
                .withIdentity(job.getJobName(), job.getJobGroup())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 */1 * * * ?"))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }


    /**
     * <p>处理已经注册到Quartz中的job任务 </p>
     * <u>
     *     <li>如果数据库中的job配置为禁止状态则将对应的job从quartz中清除</li>
     *     <li>判断数据库中配置的触发条件是否改变，如果改变则更新quartz中对应的配置</li>
     * </u>
     *
     * @param job 数据库中配置的Job信息
     * @throws SchedulerException
     */
    private void handleRegistedInQzJob(ScheduleTrigger job, JobKey jobKey) throws SchedulerException {

        if("0".equals(job.getStatus())) {
            scheduler.deleteJob(jobKey);
            return;
        }

        String cron = job.getCron();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String qzCron = trigger.getCronExpression();
        if(!cron.equals(qzCron)) {
            CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(cron);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(builder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        }

    }

}

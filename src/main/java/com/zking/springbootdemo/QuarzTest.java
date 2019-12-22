package com.zking.springbootdemo;

import com.zking.springbootdemo.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * @author Administrator
 * @create 2019-12-2021:32
 */
public class QuarzTest {

    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //需要传达的参数
        Map<String, Object> param = new HashMap<>();
        param.put("name", "小春子");

        //任务描述
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .setJobData(new JobDataMap(param))  //任务参数
                .build();

        //简单触发器，每4秒一次
        /*Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(4)
                        .repeatForever())
                .build();*/

        //cron触发器，每分钟一次
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 */1 * * * ?"))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();
        //scheduler.shutdown();
    }

}

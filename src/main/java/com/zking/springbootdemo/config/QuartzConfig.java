package com.zking.springbootdemo.config;

import com.zking.springbootdemo.job.IntegrationQzJob;
import com.zking.springbootdemo.job.IntegrationQzJob2;
import org.quartz.*;

/**
 * 配置quartz的job
 *
 * @author Administrator
 * @create 2019-12-2222:19
 */
//@Configuration
public class QuartzConfig {


    //@Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(IntegrationQzJob.class)//PrintTimeJob我们的业务类
                .withIdentity("PrintTimeJob")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .usingJobData("msg", "Hello Quartz")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }


    //@Bean
    public Trigger printTimeJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())//关联上述的JobDetail
                .withIdentity("quartzTaskService")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }


    //@Bean
    public JobDetail printTimeJobDetail2() {
        return JobBuilder.newJob(IntegrationQzJob2.class)//PrintTimeJob我们的业务类
                .withIdentity("PrintTimeJob2")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .usingJobData("msg", "Hello Quartz22")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }


    //@Bean
    public Trigger printTimeJobTrigger2() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail2())//关联上述的JobDetail
                .withIdentity("quartzTaskService2")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}

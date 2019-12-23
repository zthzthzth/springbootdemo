package com.zking.springbootdemo.job;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2019-12-2313:21
 */
@Configuration
public class SchedulerService {

    @Resource
    private Scheduler scheduler;

    @Scheduled(cron = "*/10 * * * * ?")
    public void run() {
        System.out.println("--------------------------------------");
        System.out.println("======== " + scheduler.getClass());
    }

}

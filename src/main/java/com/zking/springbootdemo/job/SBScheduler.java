package com.zking.springbootdemo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 通过spring自带的计划任务来实现一个定时启动的功能.
 * 注： 必须将类注册为spring的组件
 * @author Administrator
 * @create 2019-12-2216:28
 */
@Component
public class SBScheduler {

    /**
     * 每隔30秒执行一次
     */
    //@Scheduled(fixedRate = 30000)
    public void fixedRateScheduler() {
        System.out.println("每隔30秒执行一次 ... " + System.currentTimeMillis());
    }

    //@Scheduled(cron = "0 0/1 * * * ?")
    public void cronScheduler() {
        System.out.println("每隔1分钟执行一次 ... " + System.currentTimeMillis());
    }

}

package com.zking.springbootdemo.job;

import org.quartz.*;

/**
 * @author Administrator
 * @create 2019-12-2023:41
 */
public class HelloJob implements Job {

    /**
     * JobExecutionContext中包含了Quartz运行时的环境以及Job本身的详细数据信息
     *
     * 当Schedule调度执行一个Job的时候，就会将JobExecutionContext传递给该Job的execute()中，
     * Job就可以通过JobExecutionContext对象获取信息
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        /**
         * JobDataMap实现了JDK的Map接口，可以以Key-Value的形式存储数据,
         * JobDetail、Trigger都可以使用JobDataMap来设置一些参数或信息
         */
        JobDataMap jobDataMap = jobDetail.getJobDataMap();

        String name = jobDataMap.getString("name");

        System.out.println(String.format("hello %s 这是第一个job", name));
    }

}

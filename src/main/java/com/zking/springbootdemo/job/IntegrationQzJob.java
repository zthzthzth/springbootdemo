package com.zking.springbootdemo.job;

import com.zking.springbootdemo.service.IQuartzTestService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @create 2019-12-2222:18
 */
public class IntegrationQzJob extends QuartzJobBean {

    @Resource
    private IQuartzTestService quartzTestService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String msg = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("msg");
        System.out.println("current time :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "---" + msg);
        quartzTestService.runTest("珣宝宝");
    }

}

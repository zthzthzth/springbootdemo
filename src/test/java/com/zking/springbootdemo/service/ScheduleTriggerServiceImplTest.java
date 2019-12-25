package com.zking.springbootdemo.service;

import com.zking.springbootdemo.SpringbootdemoApplication;
import com.zking.springbootdemo.model.ScheduleTrigger;
import com.zking.springbootdemo.model.ScheduleTriggerParam;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2019-12-2412:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
class ScheduleTriggerServiceImplTest {

    @Resource
    private IScheduleTriggerService scheduleTriggerService;

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
        ScheduleTrigger scheduleTrigger = new ScheduleTrigger();
        scheduleTrigger.setJobName("com.zking.springbootdemo.job.IntegrationQzJob");
        scheduleTrigger.setCron("0 0/1 * * * ?");
        scheduleTrigger.setJobGroup("group1");
        scheduleTrigger.setStatus("1");
        int i = scheduleTriggerService.insert(scheduleTrigger);
        System.out.println("添加计划任务ID： " + i);
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void queryAll() {

        List<ScheduleTrigger> scheduleTriggers = scheduleTriggerService.queryAll();
        for(ScheduleTrigger trigger : scheduleTriggers) {
            System.out.println(trigger);
            for(ScheduleTriggerParam param: trigger.getParamList()) {
                System.out.println(param);
            }
        }

    }
}
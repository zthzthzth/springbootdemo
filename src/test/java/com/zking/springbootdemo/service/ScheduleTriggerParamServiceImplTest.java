package com.zking.springbootdemo.service;

import com.zking.springbootdemo.SpringbootdemoApplication;
import com.zking.springbootdemo.model.ScheduleTriggerParam;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2019-12-2413:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
class ScheduleTriggerParamServiceImplTest {

    @Resource
    private IScheduleTriggerParamService scheduleTriggerParamService;

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
        ScheduleTriggerParam param = new ScheduleTriggerParam();
        param.setName("msg");
        param.setValue("数据库获取参数");
        param.setScheduleTriggerId(1);
        scheduleTriggerParamService.insert(param);
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
    void listByScheduleTriggerId() {
    }
}
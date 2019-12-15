package com.zking.springbootdemo.service;

import com.zking.springbootdemo.SpringbootdemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Administrator
 * @create 2019-12-1516:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class)
class TestServiceTest {

    @Resource
    private ITestService testService;

    @Test
    void getName() {
        String t = testService.getName();
        System.out.println(t);
    }

}
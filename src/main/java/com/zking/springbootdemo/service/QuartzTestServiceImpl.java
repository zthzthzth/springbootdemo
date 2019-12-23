package com.zking.springbootdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2019-12-2316:12
 */
@Service
public class QuartzTestServiceImpl implements IQuartzTestService {

    @Override
    public void runTest(String name) {
        System.out.println("===---@@@ 测试quartz中使用springbean name = "+ name);
    }

}

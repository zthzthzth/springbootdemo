package com.zking.springbootdemo.service;

import com.zking.springbootdemo.annotation.MyLog;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @create 2019-12-1516:11
 */
@Service
public class TestService implements ITestService {

    @MyLog("test get desc value")
    //@MyLog(value = "test get desc value")
    @Override
    public String getName() {
        return "测试方法返回值";
    }

}

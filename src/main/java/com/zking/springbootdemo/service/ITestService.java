package com.zking.springbootdemo.service;

import com.zking.springbootdemo.annotation.MyLog;

/**
 * @author Administrator
 * @create 2019-12-1516:10
 */
public interface ITestService {

    @MyLog
    String getName();

}

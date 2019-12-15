package com.zking.springbootdemo.interceptor;

import com.zking.springbootdemo.annotation.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @create 2019-12-1515:34
 */
@Component
@Aspect
public class MyLogInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.zking.springbootdemo.annotation.MyLog)")
    private void MyLogInterceptor() {}


    @Before("MyLogInterceptor()")
    public void before(JoinPoint joinPoint) {

        logger.info("" + joinPoint.getSignature().getName());

        //获取拦截的方法对象，以便于获取方法上使用的注解
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();

        //获取注解
        Annotation annotation = method.getAnnotation(MyLog.class);

        //获取注解的vlaue属性
        System.out.println(((MyLog) annotation).value());
    }

}

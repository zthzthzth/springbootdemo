package com.zking.springbootdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 * @create 2019-12-1515:26
 */
//保留策略
@Retention(RetentionPolicy.RUNTIME)

//可以使用在方法上
@Target({ElementType.METHOD})
public @interface MyLog {

    //描述
    String value() default "";

}

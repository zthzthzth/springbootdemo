package com.zking.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @create 2019-12-1521:14
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        Map<String,Object> rv = new HashMap<>();
        rv.put("code", 1);
        rv.put("message", "操作成功");
        return rv;
    }

    //从URI中获取参数
    @GetMapping("/pathvar/{id}")
    public Object testPathVar(@PathVariable("id") String id) {
        System.out.println("---- id = " + id);
        Map<String,Object> rv = new HashMap<>();
        rv.put("code", 1);
        rv.put("message", "操作成功");
        rv.put("data", id);
        return rv;
    }

}

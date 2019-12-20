package com.zking.springbootdemo.controller;

import com.zking.springbootdemo.util.ResposeData;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用于测试redis集成
 * @author Administrator
 * @create 2019-12-1822:16
 */
@Api(description = "redis缓存测试接口")
@RestController
public class RedisTestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation(value="测试redis集成",notes = "用于测试redis配置是否正确")
    @ApiImplicitParam(name="content", value = "存入redis中的内容",required = true, paramType = "query",dataType = "String")
    @PostMapping(value = "/redis")
    public ResposeData redis(String content) {

        ResposeData resData = new ResposeData();

        try {
            redisTemplate.opsForValue().set("redisTest", content);
            resData.setCode(1);
            resData.setMessage("成功");
            resData.setData(content);
        } catch (Exception e) {
            resData.setCode(-1);
            resData.setMessage(e.getMessage());
            logger.info("redis测试接口异常:", e);
        }

        return resData;
    }

}

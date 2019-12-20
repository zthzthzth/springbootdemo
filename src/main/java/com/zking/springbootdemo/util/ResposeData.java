package com.zking.springbootdemo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 定义响应数据的格式
 * @author Administrator
 * @create 2019-12-2014:24
 */
@ApiModel("响应数据格式")
public class ResposeData {

    @ApiModelProperty(value="返回码", name = "code", example = "1")
    private int code;

    @ApiModelProperty(value="返回信息", name = "message", example = "操作成功")
    private String message;

    @ApiModelProperty(value="返回对象", name = "data", example = "{'name': 'zs'}")
    private Object data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

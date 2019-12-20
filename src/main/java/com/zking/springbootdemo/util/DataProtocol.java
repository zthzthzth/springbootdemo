package com.zking.springbootdemo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务器返回给客户端的JSON格式的数据
 */
@ApiModel("response data")
@SuppressWarnings("unused")
public class DataProtocol extends HashMap<String, Object> {

    public static int SUCCESS = 1;

    public static int FAIL = -1;

    @ApiModelProperty(value="返回码", name = "code", example = "1")
    private int code;

    @ApiModelProperty(value="返回对象", name = "data", example = "{'name': 'zs'}")
    private Object data;

    @ApiModelProperty(value="返回信息", name = "message", example = "操作成功")
    private String message;

    private long ts = System.currentTimeMillis();

    public DataProtocol() {
        super();
        this.put("code", SUCCESS);
        this.put("ts", ts);
        this.put("message","操作成功");
    }

    public void setCode(int code) {
        this.put("code", code);
        if(code == FAIL) {
            this.put("message","操作失败");
        } else {
            this.put("message","操作成功");
        }
    }

    public void setData(Object data) {
        this.put("data", data);
    }

    public void setError(String error) {
        this.put("error", error);
        this.put("message","操作失败");
        this.put("code", FAIL);
    }

    public void setErrors(Map<String,String> errors) {
        this.put("errros", errors);
        this.put("message","操作失败");
        this.put("code", FAIL);
    }

    public void setMessage(String message) {
        this.put("message", message);
    }

}

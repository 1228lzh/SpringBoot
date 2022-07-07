package com.ZH.controller.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R2 {
    private Boolean success;//是否成功

    private Integer code;//返回码

    private String message;//返回信息

    //@ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private R2(){}

    public static R2 ok(){
        R2 r = new R2();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static R2 error(){
        R2 r = new R2();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }



    public R2 success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R2 message(String message){
        this.setMessage(message);
        return this;
    }

    public R2 code(Integer code){
        this.setCode(code);
        return this;
    }

    public R2 data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R2 data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}

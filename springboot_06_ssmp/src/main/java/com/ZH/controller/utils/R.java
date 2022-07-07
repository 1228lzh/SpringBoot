package com.ZH.controller.utils;

import lombok.Data;

//@Data
public class R {
    private Boolean flag;//状态
    private Object data;//数据

    //无参
    public R(){

    }

    public R(Boolean flag){
        this.flag=flag;
    }

    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }


}

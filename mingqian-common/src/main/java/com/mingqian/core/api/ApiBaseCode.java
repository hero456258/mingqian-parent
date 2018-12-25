package com.mingqian.core.api;

/**
 * Api通用码
 * Created by tf on 2017/6/29.
 */
public enum ApiBaseCode {

    SC_OK(0,"成功");

    private Integer code;

    private String msg;

    ApiBaseCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

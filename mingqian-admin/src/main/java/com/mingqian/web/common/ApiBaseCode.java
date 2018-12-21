package com.mingqian.web.common;

/**
 * Created by wanggang on 2018/10/17.
 * Api通用码
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

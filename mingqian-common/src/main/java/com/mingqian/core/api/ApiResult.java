package com.mingqian.core.api;


public class ApiResult<T> {

    /**
     * 成功标识
     */
    public static final Integer SC_OK = 0;

    public static final Integer FAIL = -1;

    /**
     * 响应码
     */
    private Integer resCode;

    /**
     * 响应码描述
     */
    private String msg;

    /**
     * 响应内容
     */
    private T result;

    private ApiResult() {
    }

    public ApiResult(Integer resCode, String msg) {
        this.resCode = resCode;
        this.msg = msg;
    }

    public ApiResult(Integer resCode, String msg, T result) {
        this.resCode = resCode;
        this.msg = msg;
        this.result = result;
    }

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

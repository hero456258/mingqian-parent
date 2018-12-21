package com.mingqian.web.common;

/**
 * ApiResult工具类
 * Created by wanggang on 2018/10/17.
 */
public class ApiResultUtil {
    public static <T> ApiResult<T> ok(T result){
        return new ApiResult<T>(ApiBaseCode.SC_OK.getCode(), ApiBaseCode.SC_OK.getMsg(),result);
    }

    public static <T> ApiResult<T> error(Integer code, String msg){
        return error(code,msg,null);
    }

    public static <T> ApiResult<T> error(Integer code, String msg, T result){
        return new ApiResult<T>(code,msg,result);
    }
}

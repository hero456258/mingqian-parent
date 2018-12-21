package com.mingqian.web.common;

import com.mingqian.domain.cons.AppErrorCode;

/**
 * Created by wanggang on 2018/12/21.
 */
public class ApiResulter {
    public static <T> ApiResult<T> ok(T result) {
        return new ApiResult<T>(ApiBaseCode.SC_OK.getCode(), ApiBaseCode.SC_OK.getMsg(), result);
    }

    public static <T> ApiResult<T> ok() {
        return new ApiResult<T>(ApiBaseCode.SC_OK.getCode(), ApiBaseCode.SC_OK.getMsg(), null);
    }

    public static <T> ApiResult<T> boolBody(boolean bodyResult) {
        if (bodyResult) {
            return new ApiResult<T>(ApiBaseCode.SC_OK.getCode(), ApiBaseCode.SC_OK.getMsg(), null);
        }
        return new ApiResult<T>(AdminErrorCode.SYS_ERROR.getCode(), AdminErrorCode.SYS_ERROR.getMsg(), null);
    }


    public static <T> ApiResult<T> error(AdminErrorCode adminErrorCode) {
        return error(adminErrorCode.getCode(), adminErrorCode.getMsg(), null);
    }

    public static <T> ApiResult<T> error(AppErrorCode appErrorCode) {
        return error(appErrorCode.getCode(), appErrorCode.getMsg(), null);
    }

    public static <T> ApiResult<T> error(Integer code, String msg) {
        return error(code, msg, null);
    }

    public static <T> ApiResult<T> error(Integer code, String msg, T result) {
        return new ApiResult<T>(code, msg, result);
    }
}

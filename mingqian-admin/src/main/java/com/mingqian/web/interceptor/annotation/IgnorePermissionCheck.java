package com.mingqian.web.interceptor.annotation;

import java.lang.annotation.*;

/**
 * Created by wanggang on 2018/12/30.
 * @Description:忽略权限检查
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface IgnorePermissionCheck {
}

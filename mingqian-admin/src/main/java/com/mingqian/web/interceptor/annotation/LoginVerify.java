package com.mingqian.web.interceptor.annotation;

import java.lang.annotation.*;

/**
 * 登录注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface LoginVerify {

}

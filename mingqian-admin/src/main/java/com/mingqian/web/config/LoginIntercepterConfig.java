package com.mingqian.web.config;

import com.mingqian.web.interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wanggang on 2018/12/21.
 */
@Configuration
public class LoginIntercepterConfig extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/**");
    }
}

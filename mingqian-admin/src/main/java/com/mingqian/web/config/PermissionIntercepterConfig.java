package com.mingqian.web.config;

import com.mingqian.web.interceptor.PermissionAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by wanggang on 2018/12/30.
 */
@Configuration
public class PermissionIntercepterConfig implements WebMvcConfigurer {
    @Bean
    public PermissionAuthInterceptor permissionAuthInterceptor(){
        return  new PermissionAuthInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(permissionAuthInterceptor()).addPathPatterns("/**");
    }
}

package com.mingqian.web.controller;

import com.mingqian.web.config.PropertiesConfig;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * @ClassName: BaseController
 * @Description:提供web常用配置 对应config.properties
 * Created by wanggang on 2018/12/20.
 */
public class BaseController implements ServletContextAware {

    @Resource
    PropertiesConfig propertiesConfig;
    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("-----------------"+propertiesConfig.getWebBase());
        servletContext.setAttribute("config", propertiesConfig);
    }
}

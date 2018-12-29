package com.mingqian.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


/**
 * Created by wanggang on 2018/12/27.
 */
@Configuration
public class FreemarkerConfig {
    @Autowired
    protected freemarker.template.Configuration configuration;




    @Autowired
    protected PropertiesConfig propertiesConfig;
    @PostConstruct
    public void setConfigure() throws Exception {
        configuration.setSharedVariable("contextPath", propertiesConfig.getWebBase());
    }

}

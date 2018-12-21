package com.mingqian.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wanggang on 2018/12/20.
 */

@ConfigurationProperties(prefix = "config")
@Component
@PropertySource(value = {"classpath:config.properties"})
public class PropertiesConfig {

    @Value("${webBase}")
    private String webBase;

    @Value("${adminCookieDomain}")
    private String adminCookieDomain;

    @Value("${almanac}")
    private String almanac;

    public String getAlmanac() {
        return almanac;
    }

    public void setAlmanac(String almanac) {
        this.almanac = almanac;
    }

    public String getWebBase() {
        return webBase;
    }

    public void setWebBase(String webBase) {
        this.webBase = webBase;
    }

    public String getAdminCookieDomain() {
        return adminCookieDomain;
    }

    public void setAdminCookieDomain(String adminCookieDomain) {
        this.adminCookieDomain = adminCookieDomain;
    }

    @Override
    public String toString() {
        return "PropertiesConfig{" +
                "webBase='" + webBase + '\'' +
                ", adminCookieDomain='" + adminCookieDomain + '\'' +
                '}';
    }
}

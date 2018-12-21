package com.mingqian.web.common;

import com.alibaba.fastjson.JSON;
import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import com.mingqian.web.exception.ErrorInputException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by wanggang on 2018/10/17.
 */
public class AdminUserToken {
    /**
     * cookie密钥
     */
    private static final String ADMIN_COOKIE_KEY = "e1b92dfa5a5249ab";

    /**
     * cookie名
     */
    private static final String COOKIE_DOMAIN_KEY = "AdminToken";

    private static Logger logger = LoggerFactory.getLogger(CookieUtils.class);


    public static boolean setUserIsLogin(HttpServletResponse response, AdminAccountVo adminAccountVo) {
        String safeUserInfo = JSON.toJSONString(adminAccountVo);
        String encrypt = null;
        try {
            encrypt = RC4Encrypt.Encrypt(safeUserInfo, ADMIN_COOKIE_KEY);
        } catch (UnsupportedEncodingException e) {
            //ignore
        }
        if (StringUtils.isEmpty(encrypt)) {
            logger.error("加密用户登录数据失败！");
            return false;
        }
        //有效期15天
        CookieUtils.setCookie(response, COOKIE_DOMAIN_KEY, encrypt, 60 * 60 * 24 * 15);
        return true;
    }

    public static AdminAccountVo getAdminUser(HttpServletRequest request) {
        String safeToken = CookieUtils.getCookieValue(request, COOKIE_DOMAIN_KEY, "");
        if (StringUtils.isEmpty(safeToken)) {
            return null;
        }
        String decrypt = null;
        try {
            decrypt = RC4Encrypt.Decrypt(safeToken, ADMIN_COOKIE_KEY);
        } catch (UnsupportedEncodingException e) {
            //ignore
        }
        if(StringUtils.isEmpty(decrypt)){
            logger.warn("用户token有误！token值{}",safeToken);
            return null;
        }
        return JSON.parseObject(decrypt, AdminAccountVo.class);
    }

    public static Long getAdminUserId(HttpServletRequest request) {
        AdminAccountVo adminUser = getAdminUser(request);
        if(adminUser == null){
            throw new ErrorInputException("当前用户未登录！");
        }
        return adminUser.getUserId();
    }
}

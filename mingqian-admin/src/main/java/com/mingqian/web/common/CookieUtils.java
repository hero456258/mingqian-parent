package com.mingqian.web.common;

import com.mingqian.web.config.SystemConfig;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wanggang on 2018/10/17.
 */
public class CookieUtils {
    /**
     * Deactive when explorer closed.
     */
    private static final int DEFAULT_AGE = -1;
    private static final String DEFAULT_DOMAIN = SystemConfig.getConfigProperty("adminCookieDomain");

    /**
     * Sets the cookie
     *
     * @param response
     * @param cookieName
     * @param value
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String value) {
        setCookie(response, cookieName, value, DEFAULT_AGE);
    }

    /**
     * 按照SUN J2EE DOC的解释，如果setMaxAge为正值，
     * 则Cookie在N秒之后过期，如果为零，则删除之，如果为负值，则在浏览期关闭之后被删除。
     *
     * @param response
     * @param cookieName
     * @param value
     * @param maxSeconds
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String value, int maxSeconds) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setMaxAge(maxSeconds);
        String domain = DEFAULT_DOMAIN;
        cookie.setDomain(domain);// domain
        cookie.setPath("/");

        response.addCookie(cookie);
    }

    /**
     * Returns the value of the cookie specified by cookieName or defaultValue if
     * Cookie does not exist.
     *
     * @param request
     * @param cookieName
     * @param defaultValue
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue) {
        Cookie cookie = getCookie(request, cookieName);

        return cookie == null ? defaultValue : cookie.getValue();
    }

    /**
     * Return cookie Object specified by cookieName or null if cookie does not exist.
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

}

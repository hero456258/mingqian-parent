package com.mingqian.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by wanggang on 2018/12/21.
 * 抽象拦截器扩展
 */
public abstract class AbstractMingQianInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        // class配置了针对与所有暴露的方法都有效
        if (isForAction(method.getBeanType())) {
            // method是否忽略配置
            if (methodIsDeny(method.getMethod())) {
                return true;
            }
            return interceptResult(doIntercept(request, response, method),
                    request, response);
        }
        if (isForAction(method.getMethod())) {
            return interceptResult(doIntercept(request, response, method),
                    request, response);
        }
        return true;
    }

    /**
     *
     * @Title:interceptResult
     * @Description:验证失败跳转
     * @param:@param doIntercept
     * @param:@param response
     * @param:@param request
     * @param:@return
     * @return:boolean
     * @throws
     * @Create: 2016-5-4 下午1:07:32
     * @Author : Andy Tang
     */
    private boolean interceptResult(boolean doIntercept,
                                    HttpServletRequest request, HttpServletResponse response) {
        if (doIntercept) {
            return true;
        }
        try {
            String errorReadirectUrl = errorWhenRedirectUri();
            if(StringUtils.isEmpty(errorReadirectUrl)){
                log.error("Interceptor fail for redirect error uri is empty!");
                return false;
            }
            if(errorReadirectUrl.startsWith("http")){
                response.sendRedirect(errorReadirectUrl);
            }else{
                response.sendRedirect(request.getContextPath()+errorReadirectUrl);
            }
        } catch (IOException e) {
            log.error("Interceptor fail for redirect error ", e);
        }
        return false;
    }

    public abstract Class<? extends Annotation> getRequiredAnnotationClass();

    public abstract String errorWhenRedirectUri();

    public abstract boolean doIntercept(HttpServletRequest request,
                                        HttpServletResponse response, HandlerMethod method);

    public boolean isForAction(Class<?> clazz) {
        Class<? extends Annotation> annoClass = getRequiredAnnotationClass();
        if (annoClass == null) {
            return false;
        }
        return clazz.isAnnotationPresent(annoClass);
    }

    public boolean isForAction(Method method) {
        Class<? extends Annotation> annoClass = getRequiredAnnotationClass();
        if (annoClass == null) {
            return false;
        }
        return method.isAnnotationPresent(annoClass);
    }

    /**
     *
     * @Title:getDenyAnnotationClass
     * @Description:class标注全局验证，部分方法忽略验证配置
     * @param:@return
     * @return:Class<? extends Annotation>
     * @throws
     */
    public abstract Class<? extends Annotation> getDenyAnnotationClass();

    public boolean methodIsDeny(Method method) {
        Class<? extends Annotation> denyAnnoClass = getDenyAnnotationClass();
        if (denyAnnoClass == null) {
            return false;
        }
        return method.isAnnotationPresent(denyAnnoClass);
    }
}

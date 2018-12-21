package com.mingqian.web.interceptor;

import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import com.mingqian.web.common.AdminUserToken;
import com.mingqian.web.interceptor.annotation.IgnoreLoginVerify;
import com.mingqian.web.interceptor.annotation.LoginVerify;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * Created by wanggang on 2018/12/21.
 */
public class AdminLoginInterceptor extends  AbstractMingQianInterceptor {
    @Override
    public Class<? extends Annotation> getRequiredAnnotationClass() {
        return LoginVerify.class;
    }

    @Override
    public String errorWhenRedirectUri() {
        return "/login/toLogin";
    }

    @Override
    public boolean doIntercept(HttpServletRequest request, HttpServletResponse response, HandlerMethod method) {
        AdminAccountVo adminUser = AdminUserToken.getAdminUser(request);
        if(adminUser == null){
            return false;
        }
        return true;
    }

    /**
     * @throws
     * @Title:getDenyAnnotationClass
     * @Description:class标注全局验证，部分方法忽略验证配置
     * @param:@return
     * @return:Class<? extends Annotation>
     */
    @Override
    public Class<? extends Annotation> getDenyAnnotationClass() {
        return IgnoreLoginVerify.class;
    }
}

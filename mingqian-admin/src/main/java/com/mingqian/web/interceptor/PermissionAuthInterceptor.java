package com.mingqian.web.interceptor;

import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.service.adminRole.AdminRoleService;
import com.mingqian.service.adminStaffRoleRef.AdminStaffRoleRefService;
import com.mingqian.tools.Collections;
import com.mingqian.web.common.AdminUserToken;
import com.mingqian.web.exception.ErrorInputException;
import com.mingqian.web.interceptor.annotation.IgnorePermissionCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wanggang on 2018/12/30.
 */
public class PermissionAuthInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AdminStaffRoleRefService adminStaffRoleRefService;

    @Autowired
    AdminRoleService adminRoleService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        //忽略带有@ResponseBody的方法
        boolean isResponseBody = method.getMethod().isAnnotationPresent(ResponseBody.class);
        if(isResponseBody){
            return true;
        }
        //忽略配置了权限验证的注解
        boolean isIgnored = method.getMethod().isAnnotationPresent(IgnorePermissionCheck.class);
        if(isIgnored){
            return true;
        }
        String reqUrl = request.getRequestURI();
        AdminAccountVo adminUser = AdminUserToken.getAdminUser(request);
        if(adminUser.getUserId() == 1){ //系统管理员
            return true;
        }
        //验证权限
        Long roleId = adminStaffRoleRefService.getRoleId(adminUser.getUserId());
        List<MenuListVo> menuListVos = adminRoleService.queryAdminRoleMenusBy(roleId);
        if(Collections.isEmpty(menuListVos)){
            throw new ErrorInputException("无菜单配置！");
        }
        List<String> roleUrls = menuListVos.stream().flatMap(x -> x.getChilds().stream()).map(x->x.getReqUrl()).collect(Collectors.toList());
        if(roleUrls.contains(reqUrl)){
            return true;
        }
        response.sendRedirect("/error/permission");
        return false;
    }
}

package com.mingqian.web.controller.login;

import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import com.mingqian.service.adminAccount.AdminAccountService;
import com.mingqian.web.common.*;
import com.mingqian.web.controller.BaseController;
import com.mingqian.web.interceptor.annotation.IgnoreLoginVerify;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wanggang on 2018/12/20.
 */
@Controller
@RequestMapping("/login")
@IgnoreLoginVerify
public class LoginController  extends BaseController{
    @Resource
    private AdminAccountService adminAccountService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login/index";
    }

    @ResponseBody
    @RequestMapping("/login")
    public ApiResult<Boolean> login(String userName, String password,
                                    HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return ApiResultUtil.error(AdminErrorCode.CHECK_ERROR.getCode(), "用户名或密码错误！");
        }
        password = MD5Util.md5(password);
        AdminAccountVo adminAccountVo = adminAccountService.login(userName, password);
        if (null == adminAccountVo) {
            return ApiResultUtil.error(AdminErrorCode.CHECK_ERROR.getCode(), "用户名或密码错误！");
        }

        boolean result = AdminUserToken.setUserIsLogin(response, adminAccountVo);
        if (result) {
            request.getSession().setAttribute("loginName", userName);
            return ApiResultUtil.ok(result);
        }

        return ApiResultUtil.error(AdminErrorCode.CHECK_ERROR.getCode(), "登录失败!");
    }
}

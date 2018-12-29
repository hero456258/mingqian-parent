package com.mingqian.web.controller.adminStaffRoleRef;

import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.service.adminRole.AdminRoleService;
import com.mingqian.service.adminStaffRoleRef.AdminStaffRoleRefService;
import com.mingqian.web.common.AdminUserToken;
import com.mingqian.web.common.ApiResult;
import com.mingqian.web.common.ApiResulter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wanggang on 2018/12/28.
 */
@Controller
@RequestMapping("/user")
public class AdminStaffRoleRefController {
    @Autowired
    private AdminStaffRoleRefService adminStaffRoleRefService;

    @Autowired
    AdminRoleService adminRoleService;

    @RequestMapping("/getPermission")
    @ResponseBody
    public ApiResult  getPermissions(HttpServletRequest request){
        Long adminUserId = AdminUserToken.getAdminUserId(request);
        Long roleId = adminStaffRoleRefService.getRoleId(adminUserId);
//        List<MenuListVo> roleMenu = AdminMenuUtils.getRoleMenu(roleId);
//        if(roleMenu == null){
//            CacheUtil
//        }
        List<MenuListVo> menuListVos = adminRoleService.queryAdminRoleMenusBy(roleId);
        return ApiResulter.ok(menuListVos);
    }
}

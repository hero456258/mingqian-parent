package com.mingqian.web.controller.adminRole;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminRole.AdminRoleParamVo;
import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.service.adminMenuConf.AdminMenuConfService;
import com.mingqian.service.adminRole.AdminRoleService;
import com.mingqian.web.common.ApiResult;
import com.mingqian.web.common.ApiResulter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wanggang on 2018/12/24.
 */
@RequestMapping("/adminRole")
@Controller
public class AdminRoleController {

    @Resource
    private AdminRoleService adminRoleService;

    @Resource
    private AdminMenuConfService adminMenuConfService;

    @RequestMapping("/toList")
    public String toAdminRolePage(){
        return "/adminRole/adminRoleList";
    }

    @RequestMapping("/adminRoleList")
    @ResponseBody
    public ApiResult getAdminRoleList(AdminRoleParamVo adminRoleParamVo){
        PageBean<AdminRoleEntity> pageBean = adminRoleService.queryAdminRoleList(adminRoleParamVo);
        return ApiResulter.ok(pageBean);
    }

    @RequestMapping("/toAddAdminRolePage")
    public String toAddAdminRolePage(Model model){
        List<MenuListVo> menus = adminMenuConfService.queryAdminMenus();
        model.addAttribute("menus", menus);
        return "/adminRole/addAdminRole";
    }

}

package com.mingqian.web.controller.adminRole;

import com.google.common.collect.Lists;
import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminRole.AddAdminRoleVo;
import com.mingqian.domain.vo.adminRole.AdminRoleDetailVo;
import com.mingqian.domain.vo.adminRole.AdminRoleParamVo;
import com.mingqian.domain.vo.menu.MenuDetailVo;
import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.service.adminMenuConf.AdminMenuConfService;
import com.mingqian.service.adminRole.AdminRoleService;
import com.mingqian.tools.Collections;
import com.mingqian.web.common.ApiResult;
import com.mingqian.web.common.ApiResulter;
import com.mingqian.web.exception.ErrorInputException;
import com.mingqian.web.interceptor.annotation.LoginVerify;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wanggang on 2018/12/24.
 */
@RequestMapping("/adminRole")
@Controller
@LoginVerify
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

    @RequestMapping("/addAdminRole")
    @ResponseBody
    public ApiResult addAdminRole(@RequestBody AddAdminRoleVo adminRoleVo){
        if(adminRoleVo == null || StringUtils.isEmpty(adminRoleVo.getRoleDesc()) || StringUtils.isEmpty(adminRoleVo.getRoleName())){
            throw  new ErrorInputException("参数错误！");
        }
        boolean result = adminRoleService.addAdminRole(adminRoleVo);
        return ApiResulter.boolBody(result);
    }

    @RequestMapping("/showRolePermission")
    public String toShowRolePermissionPage(@RequestParam(name="roleId",required = true) Long roleId, Model model){
        AdminRoleDetailVo roleDetailVo = adminRoleService.queryAdminRoleMessageBy(roleId);
        //获取出所有菜单的id
        List<Long> menuIds = roleDetailVo.getMenus().stream().map(x -> x.getMenuId()).collect(Collectors.toList());
        //查询出所有的菜单
        List<MenuListVo> menuListVos = adminMenuConfService.queryAdminMenus();
        //遍历所有菜单找出相同的
        for (MenuListVo menuListVo : menuListVos) {
            if(Collections.isEmpty(menuListVo.getChilds())){
                continue;
            }
            List<MenuDetailVo> checkedMenus = Lists.newArrayList();
            for (MenuDetailVo menuDetailVo : menuListVo.getChilds()) {
                if(menuIds.contains(menuDetailVo.getMenuId())){
                    checkedMenus.add(menuDetailVo);
                }
            }
            menuListVo.setChilds(checkedMenus);
        }
        //过滤无子菜单的数据
        List<MenuListVo> newMenus = menuListVos.stream().filter(x -> !Collections.isEmpty(x.getChilds())).collect(Collectors.toList());
        model.addAttribute("roleDetailVo", roleDetailVo);
        model.addAttribute("newMenus",newMenus);
        return "/adminRole/showAdminRolePermission";
    }

    @RequestMapping("/toEditAdminRolePermissionPage")
    public String toEditAdminRolePermissionPage(@RequestParam(name="roleId",required = true) Long roleId, Model model){
        AdminRoleDetailVo roleDetailVo = adminRoleService.queryAdminRoleMessageBy(roleId);
        //获取出所有菜单的id
        List<Long> menuIds = roleDetailVo.getMenus().stream().map(x -> x.getMenuId()).collect(Collectors.toList());
        //查询出所有的菜单
        List<MenuListVo> menuListVos = adminMenuConfService.queryAdminMenus();
        //遍历所有菜单找出相同的
        for (MenuListVo menuListVo : menuListVos) {
            if(Collections.isEmpty(menuListVo.getChilds())){
                continue;
            }
            for (MenuDetailVo menuDetailVo : menuListVo.getChilds()) {
                menuDetailVo.setChecked(false);
                if(menuIds.contains(menuDetailVo.getMenuId())){
                    menuDetailVo.setChecked(true);
                }
            }
        }
        model.addAttribute("roleDetailVo", roleDetailVo);
        model.addAttribute("newMenus",menuListVos);
        return "/adminRole/editAdminRolePermission";
    }

    @RequestMapping("editAdminRole")
    @ResponseBody
    public ApiResult editAdminRole(@RequestBody AddAdminRoleVo adminRoleVo){
        if(adminRoleVo == null || StringUtils.isEmpty(adminRoleVo.getRoleName()) || adminRoleVo.getMenuIds() == null){
            throw new ErrorInputException("参数错误！");
        }
        boolean result = adminRoleService.editAdminRole(adminRoleVo);
        return ApiResulter.boolBody(result);
    }

    @RequestMapping("/deleteAdminRole")
    @ResponseBody
    public ApiResult deleteAdminRole(@RequestParam(name="roleId",required = true) Long roleId){
        boolean result = adminRoleService.deleteAdminRoleBy(roleId);
        return ApiResulter.boolBody(result);
    }

}

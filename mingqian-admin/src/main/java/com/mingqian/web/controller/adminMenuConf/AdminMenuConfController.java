package com.mingqian.web.controller.adminMenuConf;

import com.google.common.collect.Lists;
import com.mingqian.domain.vo.menu.MenuDetailVo;
import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.service.adminMenuConf.AdminMenuConfService;
import com.mingqian.web.common.ApiResult;
import com.mingqian.web.common.ApiResulter;
import com.mingqian.web.interceptor.annotation.LoginVerify;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wanggang on 2018/12/26.
 */
@Controller
@RequestMapping("/adminMenuConf")
@LoginVerify
public class AdminMenuConfController {

    @Resource
    private AdminMenuConfService adminMenuConfService;

    @RequestMapping("/toList")
    public String toAdminMenuConfPage(Model model, HttpServletRequest request){
        List<MenuListVo> menus = adminMenuConfService.queryAdminMenus();
        List<List<MenuListVo>> partition = Lists.partition(menus, 7);
        model.addAttribute("partitions",partition);
        return "/adminMenuConf/adminMenuList";
    }

    @RequestMapping("addAdminMenuConf")
    @ResponseBody
    public ApiResult addAdminMenuConf(MenuDetailVo menuDetailVo){
        boolean result = adminMenuConfService.addAdminMenuConf(menuDetailVo);
        return ApiResulter.boolBody(result);
    }

    @RequestMapping("/editAdminMenuConf")
    @ResponseBody
    public ApiResult editAdminMenuConf(MenuDetailVo menuDetailVo){
        boolean result = adminMenuConfService.editAdminMenuConf(menuDetailVo);
        return ApiResulter.boolBody(result);
    }

    @RequestMapping("/deleteAdminMenuConf")
    @ResponseBody
    public ApiResult deleteAdminMenuConf(@RequestParam(name = "menuId",required = true) Long menuId){
        boolean result = adminMenuConfService.deleteAdminMenuConf(menuId);
        return ApiResulter.boolBody(result);
    }
}

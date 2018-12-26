package com.mingqian.web.controller.adminMenuConf;

import com.google.common.collect.Lists;
import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.service.adminMenuConf.AdminMenuConfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wanggang on 2018/12/26.
 */
@Controller
@RequestMapping("/adminMenuConf")
public class AdminMenuConfController {

    @Resource
    private AdminMenuConfService adminMenuConfService;

    @RequestMapping("/toList")
    public String toAdminMenuConfPage(Model model){
        List<MenuListVo> menus = adminMenuConfService.queryAdminMenus();
        List<List<MenuListVo>> partition = Lists.partition(menus, 7);
        model.addAttribute("partition",partition);
        return "/adminMenuConf/adminMenuList";
    }
}

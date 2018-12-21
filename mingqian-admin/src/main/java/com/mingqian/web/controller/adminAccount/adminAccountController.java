package com.mingqian.web.controller.adminAccount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanggang on 2018/12/21.
 */
@Controller
@RequestMapping("/adminAccount")
public class adminAccountController {
    @RequestMapping("adminAccountList")
    public  String toAdminAccountPage(){
        return "/adminAccount/adminAccountList";
    }
}

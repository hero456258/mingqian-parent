package com.mingqian.web.controller.error;

import com.mingqian.web.interceptor.annotation.IgnorePermissionCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanggang on 2018/12/30.
 */
@RequestMapping("/error")
@Controller
public class AdminErrorController {
    @RequestMapping("/500")
    @IgnorePermissionCheck
    public String error500(){
        return "error/500";
    }

    @RequestMapping("/400")
    @IgnorePermissionCheck
    public String error400(){
        return "error/400";
    }

    @RequestMapping("/404")
    @IgnorePermissionCheck
    public String error404(){
        return "error/404";
    }

    @RequestMapping("/permission")
    @IgnorePermissionCheck
    public String errorPermission(){
        return "error/errorPermission";
    }
}

package com.mingqian.web.controller.departmentManager;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminDepartmentEntity;
import com.mingqian.domain.vo.department.DepartmentListVo;
import com.mingqian.service.department.DepartmentService;
import com.mingqian.web.common.ApiResult;
import com.mingqian.web.common.ApiResultUtil;
import com.mingqian.web.interceptor.annotation.LoginVerify;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by wanggang on 2018/12/19.
 */
@Controller
@RequestMapping("/department")
@LoginVerify
public class DepartmentController  {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/toList")
    public String toList() {
        return "department/departmentList";
    }

    @RequestMapping("/departmentList")
    @ResponseBody
    public ApiResult<PageBean<AdminDepartmentEntity>> articleList(DepartmentListVo departmentListVo) {
        PageBean<AdminDepartmentEntity> pages = departmentService.queryDepartmentList(departmentListVo);
        return ApiResultUtil.ok(pages);
    }
}

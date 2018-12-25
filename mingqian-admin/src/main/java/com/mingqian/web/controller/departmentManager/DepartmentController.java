package com.mingqian.web.controller.departmentManager;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminDepartmentEntity;
import com.mingqian.domain.vo.department.DepartmentListVo;
import com.mingqian.service.department.DepartmentService;
import com.mingqian.web.common.AdminErrorCode;
import com.mingqian.web.common.ApiResult;
import com.mingqian.web.common.ApiResultUtil;
import com.mingqian.web.common.ApiResulter;
import com.mingqian.web.interceptor.annotation.LoginVerify;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by wanggang on 2018/12/19.
 */
@Controller
@RequestMapping("/department")
@LoginVerify
public class DepartmentController {

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

    @RequestMapping("/toAdd")
    public String toAddPage(){
        return "/department/addDepartment";
    }

    @RequestMapping("addAdminDepartment")
    @ResponseBody
    public ApiResult addDepartment(AdminDepartmentEntity adminDepartmentEntity){
        adminDepartmentEntity.setCaeator(0L);
        adminDepartmentEntity.setDeleted("0");
        boolean result = departmentService.addAdminDepartment(adminDepartmentEntity);
        return result ? ApiResulter.ok() : ApiResulter.error(AdminErrorCode.SYS_ERROR);
    }

    @RequestMapping("/toEditDepartmentPage/{id}")
    public String toEditDepartmentPage(@PathVariable("id") Long id, Model model) {
        AdminDepartmentEntity adminDepartmentEntity = departmentService.queryDepartmentBy(id);
        model.addAttribute("departEntity", adminDepartmentEntity);
        return "/department/editDepartment";
    }

    @RequestMapping("/modifyDepartment")
    @ResponseBody
    public ApiResult modifyDepartment(long id, String departmentName, String departmentDesc) {
        boolean result = departmentService.modifyDepartment(id, departmentName, departmentDesc);
        return result ? ApiResulter.ok() : ApiResulter.error(AdminErrorCode.SYS_ERROR);
    }

    @RequestMapping("/deleteDepartment")
    @ResponseBody
    public ApiResult deleteDepartment(Long id){
        boolean result = departmentService.deleteDepartmentBy(id);
        return result ? ApiResulter.ok() : ApiResulter.error(AdminErrorCode.SYS_ERROR);
    }

}

package com.mingqian.web.controller.adminAccount;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminDepartmentEntity;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminAccount.AdminAccountParamVo;
import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import com.mingqian.service.adminAccount.AdminAccountService;
import com.mingqian.service.adminRole.AdminRoleService;
import com.mingqian.service.department.DepartmentService;
import com.mingqian.web.common.*;
import com.mingqian.web.exception.ErrorInputException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wanggang on 2018/12/21.
 */
@Controller
@RequestMapping("/adminAccount")
public class adminAccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AdminAccountService adminAccountService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private AdminRoleService adminRoleService;
    
    @RequestMapping("/toList")
    public String toAdminAccountPage() {
        return "/adminAccount/adminAccountList";
    }

    @RequestMapping("/adminAccountList")
    @ResponseBody
    public ApiResult<PageBean<AdminAccountVo>> getAdminAccountList(AdminAccountParamVo paramVo) {

        logger.info("adminAccountList");

        PageBean<AdminAccountVo> pages = adminAccountService.queryAdminAccountList(paramVo);

        return ApiResultUtil.ok(pages);
    }

    @RequestMapping("/toAddAdminAccountPage")
    public String toAddAdminAccountPage(Model model) {
        //查询出所有的部门
        List<AdminDepartmentEntity> departList = departmentService.queryAllDepartments();
        model.addAttribute("departList", departList);
        //查询出所有的角色
        List<AdminRoleEntity> roles = adminRoleService.queryAllRoles();
        model.addAttribute("roles", roles);
        return "/adminAccount/addAdminAccount";
    }

    @RequestMapping("/addAdminAccount")
    @ResponseBody
    public ApiResult addAdminAccount(@RequestBody AdminAccountVo accountVo){
        boolean result = adminAccountService.addAdminAccount(accountVo);
        return result ? ApiResulter.ok() : ApiResulter.error(AdminErrorCode.SYS_ERROR);
    }

    @RequestMapping("/toEditAdminAccountPage")
    public String toEditAdminAccountPage(Long id,Model model){
        if(id == null ){
            throw new ErrorInputException("参数为空！");
        }
        AdminAccountVo accountVo = adminAccountService.queryAdminAccountBy(id);
        model.addAttribute("accountVo", accountVo);
        List<AdminRoleEntity> roles = adminRoleService.queryAllRoles();
        model.addAttribute("roles", roles);
        List<AdminDepartmentEntity> departmentList = departmentService.queryAllDepartments();
        model.addAttribute("departmentList", departmentList);
        return "/adminAccount/editAdminAccount";
    }

    @RequestMapping("/updateAdminAccount")
    @ResponseBody
    public ApiResult updateAdminAccount(@RequestBody AdminAccountVo accountVo){
        boolean result = adminAccountService.modifyAdminAccount(accountVo);
        return result ? ApiResulter.ok() : ApiResulter.error(AdminErrorCode.SYS_ERROR);
    }

    @RequestMapping("resetPwd")
    @ResponseBody
    public ApiResult resetPwd(String password, Long userId){
        if(StringUtils.isEmpty(password) || userId == null || userId <= 0){
            return ApiResulter.error(AdminErrorCode.INPUT_ERROR);
        }
        boolean result = adminAccountService.modifyAdminAccountPasswordBy(userId, MD5Util.md5(password));
        return ApiResulter.boolBody(result);
    }

    @RequestMapping("/deleteAdminAccount")
    @ResponseBody
    public ApiResult deleteAdminAccount(Long userId){
        if(userId == null){
            return ApiResulter.error(AdminErrorCode.INPUT_ERROR);
        }
        boolean result = adminAccountService.deleteAdminAccountBy(userId);
        return result ? ApiResulter.ok() : ApiResulter.error(AdminErrorCode.SYS_ERROR);
    }

}

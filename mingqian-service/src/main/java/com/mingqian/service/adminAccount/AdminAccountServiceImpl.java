package com.mingqian.service.adminAccount;

import com.google.common.collect.Lists;
import com.mingqian.dao.mall.mapper.AdminAccountEntityMapper;
import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.base.PageBeanUtils;
import com.mingqian.domain.mybatis.entity.AdminAccountEntity;
import com.mingqian.domain.mybatis.entity.AdminStaffEntity;
import com.mingqian.domain.mybatis.entity.AdminStaffRoleRefEntity;
import com.mingqian.domain.vo.adminAccount.AdminAccountParamVo;
import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import com.mingqian.service.adminRole.AdminRoleService;
import com.mingqian.service.adminStaff.AdminStaffService;
import com.mingqian.service.adminStaffRoleRef.AdminStaffRoleRefService;
import com.mingqian.service.department.DepartmentService;
import com.mingqian.tools.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanggang on 2018/12/20.
 */
@Service("adminAccountService")
public class AdminAccountServiceImpl implements AdminAccountService {

    @Autowired
    private AdminAccountEntityMapper adminAccountEntityMapper;

    @Autowired
    private AdminStaffService adminStaffService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AdminStaffRoleRefService adminStaffRoleRefService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Override
    public AdminAccountVo login(String userName, String password) {

        AdminAccountEntity adminAccountEntity = adminAccountEntityMapper.selectUserByUserNameAndPassword(userName, password);
        if (null == adminAccountEntity) {
            return null;
        }
        AdminAccountVo adminAccountVo = new AdminAccountVo();
        BeanUtils.copyProperties(adminAccountEntity, adminAccountVo);
        adminAccountVo.setRoleId(adminStaffRoleRefService.getRoleId(adminAccountVo.getUserId()));
        return adminAccountVo;
    }

    @Override
    public PageBean<AdminAccountVo> queryAdminAccountList(AdminAccountParamVo paramVo) {
        List<AdminAccountEntity> accountList = adminAccountEntityMapper.selectAdminAccountList(paramVo);
        ArrayList<AdminAccountVo> listVo = Lists.newArrayList();
        for (AdminAccountEntity adminAccountEntity : accountList) {
            AdminAccountVo adminAccountVo = new AdminAccountVo();
            adminAccountVo.setUserId(adminAccountEntity.getUserId());
            adminAccountVo.setRealName(adminAccountEntity.getRealName());
            adminAccountVo.setLoginName(adminAccountEntity.getLoginName());
            adminAccountVo.setLoginPwd(adminAccountEntity.getLoginPwd());
            adminAccountVo.setStatus(adminAccountEntity.getStatus());
            adminAccountVo.setEmail(adminAccountEntity.getEmail());
            Long departmentId = adminStaffService.queryDepartmentId(adminAccountEntity.getUserId());
            adminAccountVo.setDepartmentId(departmentId);
            String departmentName = departmentService.queryDepartmentNameBy(departmentId);
            adminAccountVo.setDepartmentName(departmentName);
            Long roleId = adminStaffRoleRefService.getRoleId(adminAccountEntity.getUserId());
            String roleName = adminRoleService.queryRoleNameBy(roleId);
            adminAccountVo.setRoleName(roleName);
            listVo.add(adminAccountVo);
        }

        int count = adminAccountEntityMapper.selectAdminAccountCount(paramVo);

        return PageBeanUtils.make(listVo, count);
    }

    /**
     * 添加用户
     *
     * @param accountVo
     * @return
     */
    @Override
    @Transactional
    public boolean addAdminAccount(AdminAccountVo accountVo) {
        accountVo.setLoginPwd(MD5Util.md5(accountVo.getLoginPwd()));
        int line = adminAccountEntityMapper.insertAdminAccount(accountVo);
        if (line >= 1) {
            AdminAccountEntity adminAccountEntity = adminAccountEntityMapper.selectAdminAccountByUserNameAndPassword(accountVo.getLoginName(), accountVo.getLoginPwd(),accountVo.getStatus());
            AdminStaffEntity adminStaffEntity = new AdminStaffEntity();
            adminStaffEntity.setStaffId(adminAccountEntity.getUserId());
            adminStaffEntity.setParentId(accountVo.getDepartmentId());
            adminStaffEntity.setStaffName(adminAccountEntity.getRealName());
            adminStaffEntity.setDeleted("0");
            boolean result = adminStaffService.addAdminStaff(adminStaffEntity);
            if (result) {
                AdminStaffRoleRefEntity adminStaffRoleRefEntity = new AdminStaffRoleRefEntity();
                adminStaffRoleRefEntity.setStaffId(adminAccountEntity.getUserId());
                adminStaffRoleRefEntity.setRoleId(accountVo.getRoleId());
                adminStaffRoleRefEntity.setCreator(0L);
                boolean isSuccess = adminStaffRoleRefService.addAdminStaffRoleRef(adminStaffRoleRefEntity);
                if (isSuccess) {
                    return true;
                }
            }
        }
        return false;
    }

}

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
            AdminAccountEntity adminAccountEntity = adminAccountEntityMapper.selectAdminAccountByUserNameAndPassword(accountVo.getLoginName(), accountVo.getLoginPwd(), accountVo.getStatus());
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

    /**
     * 通过用户id获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public AdminAccountVo queryAdminAccountBy(Long id) {
        AdminAccountEntity adminAccountEntity = adminAccountEntityMapper.selectAdminAccountBy(id);
        AdminAccountVo accountVo = new AdminAccountVo();
        accountVo.setUserId(adminAccountEntity.getUserId());
        accountVo.setRealName(adminAccountEntity.getRealName());
        accountVo.setLoginName(adminAccountEntity.getLoginName());
        accountVo.setLoginPwd(adminAccountEntity.getLoginPwd());
        accountVo.setStatus(adminAccountEntity.getStatus());
        accountVo.setEmail(adminAccountEntity.getEmail());
        Long departmentId = adminStaffService.queryDepartmentId(adminAccountEntity.getUserId());
        accountVo.setDepartmentId(departmentId);
        Long roleId = adminStaffRoleRefService.getRoleId(adminAccountEntity.getUserId());
        accountVo.setRoleId(roleId);
        return accountVo;
    }

    /**
     * 修改用户信息
     *
     * @param accountVo
     * @return
     */
    @Override
    @Transactional
    public boolean modifyAdminAccount(AdminAccountVo accountVo) {
        accountVo.setLoginPwd(MD5Util.md5(accountVo.getLoginPwd()));
        int line = adminAccountEntityMapper.updateAdminAccount(accountVo);
        if (line >= 1) {
            AdminStaffEntity adminStaffEntity = new AdminStaffEntity();
            adminStaffEntity.setStaffId(accountVo.getUserId());
            adminStaffEntity.setStaffName(accountVo.getRealName());
            adminStaffEntity.setParentId(accountVo.getDepartmentId());
            boolean result = adminStaffService.modifyAdminStaff(adminStaffEntity);
            if (result) {
                AdminStaffRoleRefEntity adminStaffRoleRefEntity = new AdminStaffRoleRefEntity();
                adminStaffRoleRefEntity.setStaffId(accountVo.getUserId());
                adminStaffRoleRefEntity.setRoleId(accountVo.getRoleId());
                boolean isSuccess = adminStaffRoleRefService.modifyAdminStaffRoleRef(adminStaffRoleRefEntity);
                if (isSuccess) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param s
     * @return
     */
    @Override
    public boolean modifyAdminAccountPasswordBy(Long userId, String password) {
        return adminAccountEntityMapper.updateAdminAccountPassword(userId, password) > 0;
    }

    /**
     * 通过用户id删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public boolean deleteAdminAccountBy(Long userId) {
        return adminAccountEntityMapper.deleteAdminAccountBy(userId) > 0;
    }

}

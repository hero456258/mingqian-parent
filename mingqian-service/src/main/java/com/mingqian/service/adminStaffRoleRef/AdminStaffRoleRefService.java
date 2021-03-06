package com.mingqian.service.adminStaffRoleRef;

import com.mingqian.domain.mybatis.entity.AdminStaffRoleRefEntity;

/**
 * Created by wanggang on 2018/12/20.
 */
public interface AdminStaffRoleRefService {

    /**
     * 通过userId获取roleId
     * @param userId
     * @return
     */
    Long getRoleId(Long userId);

    boolean addAdminStaffRoleRef(AdminStaffRoleRefEntity adminStaffRoleRefEntity);

    /**
     * 修改用户角色对应关系表
     * @param adminStaffRoleRefEntity
     * @return
     */
    boolean modifyAdminStaffRoleRef(AdminStaffRoleRefEntity adminStaffRoleRefEntity);
}

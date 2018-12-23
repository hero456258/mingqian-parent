package com.mingqian.service.adminStaffRoleRef;

import com.mingqian.dao.mall.mapper.AdminStaffRoleRefEntityMapper;
import com.mingqian.domain.mybatis.entity.AdminStaffRoleRefEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanggang on 2018/12/20.
 */
@Service("adminStaffRoleRef")
public class AdminStaffRoleRefServiceImpl implements AdminStaffRoleRefService {

    @Autowired
    private AdminStaffRoleRefEntityMapper adminStaffRoleRefEntityMapper;
    /**
     * 通过userId获取roleId
     *
     * @param userId
     * @return
     */
    @Override
    public Long getRoleId(Long userId) {
        return adminStaffRoleRefEntityMapper.selectRoleIdBy(userId);
    }

    @Override
    public boolean addAdminStaffRoleRef(AdminStaffRoleRefEntity adminStaffRoleRefEntity) {
        return adminStaffRoleRefEntityMapper.insertAdminStaffRoleRef(adminStaffRoleRefEntity) > 0;
    }

    /**
     * 修改用户角色对应关系表
     *
     * @param adminStaffRoleRefEntity
     * @return
     */
    @Override
    public boolean modifyAdminStaffRoleRef(AdminStaffRoleRefEntity adminStaffRoleRefEntity) {
        return adminStaffRoleRefEntityMapper.updateAdminStaffRoleRef(adminStaffRoleRefEntity) > 0;
    }
}

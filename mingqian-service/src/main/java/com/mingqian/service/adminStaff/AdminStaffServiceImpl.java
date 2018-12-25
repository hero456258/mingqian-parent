package com.mingqian.service.adminStaff;

import com.mingqian.dao.mall.mapper.AdminStaffEntityMapper;
import com.mingqian.domain.mybatis.entity.AdminStaffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanggang on 2018/12/23.
 */
@Service("adminStaffService")
public class AdminStaffServiceImpl implements AdminStaffService {
    @Autowired
    private AdminStaffEntityMapper adminStaffEntityMapper;

    @Override
    public Long queryDepartmentId(Long userId) {
        return adminStaffEntityMapper.selectDepartmentId(userId);
    }

    @Override
    public boolean addAdminStaff(AdminStaffEntity adminStaffEntity) {
        return adminStaffEntityMapper.insertAdminStaff(adminStaffEntity) > 0;
    }

    /**
     * 修改用户信息
     *
     * @param adminStaffEntity
     * @return
     */
    @Override
    public boolean modifyAdminStaff(AdminStaffEntity adminStaffEntity) {
        return adminStaffEntityMapper.updateAdminStaff(adminStaffEntity) > 0;
    }


}

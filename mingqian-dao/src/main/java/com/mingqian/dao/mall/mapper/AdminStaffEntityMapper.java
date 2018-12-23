package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.AdminStaffEntity;

public interface AdminStaffEntityMapper {
    int deleteByPrimaryKey(Long staffId);

    int insert(AdminStaffEntity record);

    int insertSelective(AdminStaffEntity record);

    AdminStaffEntity selectByPrimaryKey(Long staffId);

    int updateByPrimaryKeySelective(AdminStaffEntity record);

    int updateByPrimaryKey(AdminStaffEntity record);

    Long selectDepartmentId(Long userId);

    int insertAdminStaff(AdminStaffEntity adminStaffEntity);
}
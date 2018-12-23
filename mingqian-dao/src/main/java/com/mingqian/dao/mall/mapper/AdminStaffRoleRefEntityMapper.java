package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.AdminStaffRoleRefEntity;
import org.apache.ibatis.annotations.Param;

public interface AdminStaffRoleRefEntityMapper {
    int insert(AdminStaffRoleRefEntity record);

    int insertSelective(AdminStaffRoleRefEntity record);

    Long selectRoleIdBy(@Param("userId") Long userId);

    int insertAdminStaffRoleRef(AdminStaffRoleRefEntity adminStaffRoleRefEntity);
}
package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.AdminStaffRoleEntity;
import org.apache.ibatis.annotations.Param;

public interface AdminStaffRoleEntityMapper {
    int insert(AdminStaffRoleEntity record);

    int insertSelective(AdminStaffRoleEntity record);

    Long selectRoleIdBy(@Param("userId") Long userId);
}
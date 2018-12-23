package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleEntityMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(AdminRoleEntity record);

    int insertSelective(AdminRoleEntity record);

    AdminRoleEntity selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(AdminRoleEntity record);

    int updateByPrimaryKey(AdminRoleEntity record);

    String selectRoleNameBy(@Param("roleId") Long roleId);

    List<AdminRoleEntity> selectAllRoles();
}
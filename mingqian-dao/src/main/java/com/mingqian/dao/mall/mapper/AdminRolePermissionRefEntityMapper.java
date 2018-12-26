package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.AdminRolePermissionRefEntity;
import com.mingqian.domain.vo.menu.MenuDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRolePermissionRefEntityMapper {
    int insert(AdminRolePermissionRefEntity record);

    int insertSelective(AdminRolePermissionRefEntity record);

    int deleteAdminRolePermissionRefBy(@Param("roleId") Long roleId);

    int insertAdminRolePermissionRef(@Param("roleId") Long roleId, @Param("list") List<Long> menuIds);

    List<MenuDetailVo> selectAdminRolePermissionBy(@Param("roleId") Long roleId);
}
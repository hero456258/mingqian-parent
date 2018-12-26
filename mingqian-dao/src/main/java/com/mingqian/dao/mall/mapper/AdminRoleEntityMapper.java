package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminRole.AddAdminRoleVo;
import com.mingqian.domain.vo.adminRole.AdminRoleDetailVo;
import com.mingqian.domain.vo.adminRole.AdminRoleParamVo;
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

    List<AdminRoleEntity> selectAdminRoleList(AdminRoleParamVo adminRoleParamVo);

    Integer selectAdminRoleListCount(AdminRoleParamVo adminRoleParamVo);

    int insertAdminRole(AddAdminRoleVo adminRoleVo);

    AdminRoleEntity selectAdminRoleByRoleName(@Param("roleName") String roleName);

    AdminRoleDetailVo selectAdminRoleMessageBy(@Param("roleId") Long roleId);

    int updateAdminRole(AddAdminRoleVo adminRoleVo);

    int deleteAdminRoleBy(@Param("roleId") Long roleId);
}
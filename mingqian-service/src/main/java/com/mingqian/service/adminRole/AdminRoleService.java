package com.mingqian.service.adminRole;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminRole.AdminRoleParamVo;

import java.util.List;

/**
 * Created by wanggang on 2018/12/23.
 */
public interface AdminRoleService {
    /**
     * 通过roleId来获取roleName
     * @param roleId
     * @return
     */
    String queryRoleNameBy(Long roleId);

    /**
     * 查询出所有的角色
     * @return
     */
    List<AdminRoleEntity> queryAllRoles();

    /**
     * 角色列表分页
     * @param adminRoleParamVo
     * @return
     */
    PageBean<AdminRoleEntity> queryAdminRoleList(AdminRoleParamVo adminRoleParamVo);
}

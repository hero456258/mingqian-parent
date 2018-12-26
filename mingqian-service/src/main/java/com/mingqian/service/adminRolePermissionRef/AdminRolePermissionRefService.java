package com.mingqian.service.adminRolePermissionRef;

import com.mingqian.domain.vo.menu.MenuDetailVo;

import java.util.List;

/**
 * Created by wanggang on 2018/12/26.
 */
public interface AdminRolePermissionRefService {

    /**
     * 添加角色和权限关联关系表
     * @param roleId
     * @param menuIds
     * @return
     */
    boolean addAdminRolePermissionRef(Long roleId, List<Long> menuIds);

    /**
     * 查看角色的权限
     * @param roleId
     * @return
     */
    List<MenuDetailVo> queryRolePermissionsBy(Long roleId);
}

package com.mingqian.service.adminRolePermissionRef;

import com.mingqian.dao.mall.mapper.AdminRolePermissionRefEntityMapper;
import com.mingqian.domain.vo.menu.MenuDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wanggang on 2018/12/26.
 */
@Service("adminRolePermissionRefService")
public class AdminRolePermissionRefServiceImpl implements AdminRolePermissionRefService {

    @Autowired
    private AdminRolePermissionRefEntityMapper adminRolePermissionRefEntityMapper;
    /**
     * 添加角色和权限关联关系表
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    @Transactional
    @Override
    public boolean addAdminRolePermissionRef(Long roleId, List<Long> menuIds) {
        //删除已经添加的权限关系
        int count = adminRolePermissionRefEntityMapper.deleteAdminRolePermissionRefBy(roleId);
        //添加新的权限关系
        boolean result = adminRolePermissionRefEntityMapper.insertAdminRolePermissionRef(roleId, menuIds) > 0;
        return result;
    }

    /**
     * 查看角色的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<MenuDetailVo> queryRolePermissionsBy(Long roleId) {
        return adminRolePermissionRefEntityMapper.selectAdminRolePermissionBy(roleId);
    }

}

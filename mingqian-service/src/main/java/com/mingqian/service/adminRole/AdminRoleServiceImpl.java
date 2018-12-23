package com.mingqian.service.adminRole;

import com.mingqian.dao.mall.mapper.AdminRoleEntityMapper;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanggang on 2018/12/23.
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleEntityMapper adminRoleEntityMapper;

    @Override
    public String queryRoleNameBy(Long roleId) {
        return adminRoleEntityMapper.selectRoleNameBy(roleId);
    }

    /**
     * 查询出所有的角色
     *
     * @return
     */
    @Override
    public List<AdminRoleEntity> queryAllRoles() {
        return adminRoleEntityMapper.selectAllRoles();
    }
}

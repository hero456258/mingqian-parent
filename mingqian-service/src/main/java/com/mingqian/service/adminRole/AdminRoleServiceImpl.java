package com.mingqian.service.adminRole;

import com.mingqian.dao.mall.mapper.AdminRoleEntityMapper;
import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.base.PageBeanUtils;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminRole.AdminRoleParamVo;
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

    /**
     * 角色列表分页
     *
     * @param adminRoleParamVo
     * @return
     */
    @Override
    public PageBean<AdminRoleEntity> queryAdminRoleList(AdminRoleParamVo adminRoleParamVo) {
        List<AdminRoleEntity> roleEntity = adminRoleEntityMapper.selectAdminRoleList(adminRoleParamVo);
//        for (AdminRoleEntity adminRoleEntity : roleEntity) {
//            adminRoleEntity.setCreateTime(adminRoleEntity.getCreateTime().substring(0,adminRoleEntity.getCreateTime().length()-2));
//        }
        Integer sum = adminRoleEntityMapper.selectAdminRoleListCount(adminRoleParamVo);
        return PageBeanUtils.make(roleEntity, sum == null ? 0 : sum);
    }
}

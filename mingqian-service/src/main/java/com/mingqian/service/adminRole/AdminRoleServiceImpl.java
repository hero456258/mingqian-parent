package com.mingqian.service.adminRole;

import com.mingqian.core.exception.ErrorInputException;
import com.mingqian.dao.mall.mapper.AdminRoleEntityMapper;
import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.base.PageBeanUtils;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminRole.AddAdminRoleVo;
import com.mingqian.domain.vo.adminRole.AdminRoleDetailVo;
import com.mingqian.domain.vo.adminRole.AdminRoleParamVo;
import com.mingqian.domain.vo.menu.MenuDetailVo;
import com.mingqian.service.adminRolePermissionRef.AdminRolePermissionRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wanggang on 2018/12/23.
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleEntityMapper adminRoleEntityMapper;

    @Autowired
    private AdminRolePermissionRefService adminRolePermissionRefService;

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

    /**
     * 添加角色
     *
     * @param adminRoleVo
     * @return
     */
    @Override
    @Transactional
    public boolean addAdminRole(AddAdminRoleVo adminRoleVo) {
       boolean result =  adminRoleEntityMapper.insertAdminRole(adminRoleVo) > 0;
       if (result){
           AdminRoleEntity adminRoleEntity = adminRoleEntityMapper.selectAdminRoleByRoleName(adminRoleVo.getRoleName());
           //插入角色权限关联关系表
           boolean isSuccess = adminRolePermissionRefService.addAdminRolePermissionRef(adminRoleEntity.getRoleId(),adminRoleVo.getMenuIds());
           if(isSuccess){
               return true;
           }
       }
        return false;
    }

    /**
     * 询角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    public AdminRoleDetailVo queryAdminRoleMessageBy(Long roleId) {
        AdminRoleDetailVo roleDetailVo = adminRoleEntityMapper.selectAdminRoleMessageBy(roleId);
        if(roleDetailVo ==  null){
            throw new ErrorInputException("角色信息不存在！");
        }
        List<MenuDetailVo> menuDetailVo = adminRolePermissionRefService.queryRolePermissionsBy(roleId);
        roleDetailVo.setMenus(menuDetailVo);
        return roleDetailVo;
    }

    /**
     * 编辑角色信息以及权限
     *
     * @param adminRoleVo
     * @return
     */
    @Override
    @Transactional
    public boolean editAdminRole(AddAdminRoleVo adminRoleVo) {
        boolean result = adminRoleEntityMapper.updateAdminRole(adminRoleVo) > 0;
        adminRolePermissionRefService.addAdminRolePermissionRef(adminRoleVo.getRoleId(),adminRoleVo.getMenuIds());
        return true;
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @Override
    public boolean deleteAdminRoleBy(Long roleId) {
        return adminRoleEntityMapper.deleteAdminRoleBy(roleId) > 0;
    }
}

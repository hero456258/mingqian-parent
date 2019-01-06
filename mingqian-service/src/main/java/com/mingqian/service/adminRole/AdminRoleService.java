package com.mingqian.service.adminRole;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminRoleEntity;
import com.mingqian.domain.vo.adminRole.AddAdminRoleVo;
import com.mingqian.domain.vo.adminRole.AdminRoleDetailVo;
import com.mingqian.domain.vo.adminRole.AdminRoleParamVo;
import com.mingqian.domain.vo.menu.MenuListVo;

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

    /**
     * 添加角色
     * @param adminRoleVo
     * @return
     */
    boolean addAdminRole(AddAdminRoleVo adminRoleVo);


    /**
     * 查询角色信息
     * @param roleId
     * @return
     */
    AdminRoleDetailVo queryAdminRoleMessageBy(Long roleId);

    /**
     * 编辑角色信息以及权限
     * @param adminRoleVo
     * @return
     */
    boolean editAdminRole(AddAdminRoleVo adminRoleVo);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    boolean deleteAdminRoleBy(Long roleId);

    /**
     * 加载管理员菜单
     * @param roleId
     * @return
     */
    List<MenuListVo> queryAdminRoleMenusBy(Long roleId);

}

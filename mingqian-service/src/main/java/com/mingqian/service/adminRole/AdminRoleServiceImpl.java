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
import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.service.adminMenuConf.AdminMenuConfService;
import com.mingqian.service.adminRolePermissionRef.AdminRolePermissionRefService;
import com.mingqian.tools.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wanggang on 2018/12/23.
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleEntityMapper adminRoleEntityMapper;

    @Autowired
    private AdminRolePermissionRefService adminRolePermissionRefService;

    @Autowired
    private AdminMenuConfService adminMenuConfService;

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

    /**
     * 加载管理员菜单
     *
     * @param roleId
     * @return
     */
    @Override
    public List<MenuListVo> queryAdminRoleMenusBy(Long roleId) {
        List<MenuDetailVo> roleMenus = adminRolePermissionRefService.queryRolePermissionsBy(roleId);
        List<Long> roleMenuIds = roleMenus.stream().map(x -> x.getMenuId()).collect(Collectors.toList());
        //加载系统所有菜单
        List<MenuListVo> menus = adminMenuConfService.queryAdminMenus();
        for (MenuListVo menu : menus) {
            if(Collections.isEmpty(menu.getChilds())){
                continue;
            }
            List<MenuDetailVo> checkedMenu = new ArrayList<>();
            for (MenuDetailVo menuDetailVo : menu.getChilds()) {
                if(roleMenuIds.contains(menuDetailVo.getMenuId())){
                    checkedMenu.add(menuDetailVo);
                }
            }
            menu.setChilds(checkedMenu);
        }
        //过滤无子菜单的数据
        return menus.stream().filter(x -> !Collections.isEmpty(x.getChilds())).collect(Collectors.toList());
    }
}

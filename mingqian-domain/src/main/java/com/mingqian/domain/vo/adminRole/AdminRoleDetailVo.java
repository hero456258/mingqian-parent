package com.mingqian.domain.vo.adminRole;

import com.mingqian.domain.vo.menu.MenuDetailVo;

import java.util.List;

/**
 * Created by wanggang on 2018/12/26.
 */
public class AdminRoleDetailVo {
    private Long roleId;

    private String roleName;

    private String roleDesc;

    private List<MenuDetailVo> menus;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<MenuDetailVo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDetailVo> menus) {
        this.menus = menus;
    }
}

package com.mingqian.domain.mybatis.entity;

import java.util.Date;

/**
 * 
 *
 * @author wanggang
 * @date 2018-12-26
 *
 */
public class AdminRolePermissionRefEntity {
    /** 角色id */
    private Long roleId;

    /** 菜单id */
    private Long menuId;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 删除状态0未删除 1已删除 */
    private String deleted;

    /** 操作人id */
    private Long caeator;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public Long getCaeator() {
        return caeator;
    }

    public void setCaeator(Long caeator) {
        this.caeator = caeator;
    }
}
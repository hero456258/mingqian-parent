package com.mingqian.domain.mybatis.entity;

import java.util.Date;

/**
 * 
 *
 * @author wanggang
 * @date 2018-12-25
 *
 */
public class AdminMenuConfEntity {
    /** 菜单id */
    private Long menuId;

    /** 菜单名称 */
    private String menuName;

    /** 菜单描述 */
    private String menuDesc;

    /** 请求地址 */
    private String reqUrl;

    /** 上级id */
    private Long parentMenuId;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 删除状态0未删除 1已删除 */
    private String deleted;

    /** 操作人id */
    private Long creator;

    /** fontawesome图标样式 */
    private String fontaweCss;

    /** 是否显示0不显示 1显示 */
    private String showMenu;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
    }

    public Long getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
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

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getFontaweCss() {
        return fontaweCss;
    }

    public void setFontaweCss(String fontaweCss) {
        this.fontaweCss = fontaweCss == null ? null : fontaweCss.trim();
    }

    public String getShowMenu() {
        return showMenu;
    }

    public void setShowMenu(String showMenu) {
        this.showMenu = showMenu == null ? null : showMenu.trim();
    }
}
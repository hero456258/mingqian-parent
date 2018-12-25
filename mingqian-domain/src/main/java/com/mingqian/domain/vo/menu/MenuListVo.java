package com.mingqian.domain.vo.menu;

import java.util.List;

/**
 * Created by wanggang on 2018/12/25.
 */
public class MenuListVo {
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

    /** fontawesome图标样式 */
    private String fontaweCss;

    List<MenuDetailVo> childs;

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
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public Long getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getFontaweCss() {
        return fontaweCss;
    }

    public void setFontaweCss(String fontaweCss) {
        this.fontaweCss = fontaweCss;
    }

    public List<MenuDetailVo> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuDetailVo> childs) {
        this.childs = childs;
    }
}

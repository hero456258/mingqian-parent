package com.mingqian.service.adminMenuConf;

import com.mingqian.domain.vo.menu.MenuListVo;

import java.util.List;

/**
 * Created by wanggang on 2018/12/25.
 */
public interface AdminMenuConfService {

    /**
     * 查询所有菜单配置
     * @return
     */
    List<MenuListVo> queryAdminMenus();
}

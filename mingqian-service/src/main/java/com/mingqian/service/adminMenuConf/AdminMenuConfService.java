package com.mingqian.service.adminMenuConf;

import com.mingqian.domain.vo.menu.MenuDetailVo;
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

    /**
     * 添加子菜单
     * @param menuDetailVo
     * @return
     */
    boolean addAdminMenuConf(MenuDetailVo menuDetailVo);

    /**
     * 编辑子菜单
     * @param menuDetailVo
     * @return
     */
    boolean editAdminMenuConf(MenuDetailVo menuDetailVo);

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    boolean deleteAdminMenuConf(Long menuId);
}

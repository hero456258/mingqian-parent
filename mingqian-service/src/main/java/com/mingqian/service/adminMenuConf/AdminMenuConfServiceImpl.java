package com.mingqian.service.adminMenuConf;

import com.google.common.collect.Lists;
import com.mingqian.dao.mall.mapper.AdminMenuConfEntityMapper;
import com.mingqian.domain.mybatis.entity.AdminMenuConfEntity;
import com.mingqian.domain.vo.menu.MenuDetailVo;
import com.mingqian.domain.vo.menu.MenuListVo;
import com.mingqian.tools.Collections;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wanggang on 2018/12/25.
 */
@Service("adminMenuConfService")
public class AdminMenuConfServiceImpl implements AdminMenuConfService {

    @Autowired
    private AdminMenuConfEntityMapper adminMenuConfEntityMapper;

    /**
     * 查询所有菜单配置
     *
     * @return
     */
    @Override
    public List<MenuListVo> queryAdminMenus() {
        //查询出所有的父级菜单
        List<MenuListVo> parentMenus = adminMenuConfEntityMapper.selectAdminParentMenus();
        if (Collections.isEmpty(parentMenus)) {
            return Lists.newArrayList();
        }
        List<Long> menuIds = parentMenus.stream().map(x -> x.getMenuId()).collect(Collectors.toList());
        List<AdminMenuConfEntity> menuConfEntities = adminMenuConfEntityMapper.selectAdminChildMenus(menuIds);
        //如果子菜单没有直接返回父级菜单
        if (Collections.isEmpty(menuConfEntities)) {
            return parentMenus;
        }
        //定义一个子菜单的集合
        List<MenuDetailVo> childMenus = Lists.newArrayListWithCapacity(menuConfEntities.size());

        //遍历查询出来的子菜单集合并添加到childMenus这个集合中
        for (AdminMenuConfEntity menuConfEntity : menuConfEntities) {
            MenuDetailVo menuDetailVo = new MenuDetailVo();
            BeanUtils.copyProperties(menuConfEntity, menuDetailVo);
            childMenus.add(menuDetailVo);
        }
        Map<Long, List<MenuDetailVo>> collect = childMenus.stream().collect(Collectors.groupingBy(x -> x.getParentMenuId()));
        for (MenuListVo parentMenu : parentMenus) {
            parentMenu.setChilds(collect.get(parentMenu.getMenuId()));
        }
        return parentMenus;
    }

    /**
     * 添加子菜单
     *
     * @param menuDetailVo
     * @return
     */
    @Override
    public boolean addAdminMenuConf(MenuDetailVo menuDetailVo) {
        return adminMenuConfEntityMapper.insertAdminMenuConf(menuDetailVo) > 0;
    }

    /**
     * 编辑子菜单
     *
     * @param menuDetailVo
     * @return
     */
    @Override
    public boolean editAdminMenuConf(MenuDetailVo menuDetailVo) {
        return adminMenuConfEntityMapper.updateAdminMenuConf(menuDetailVo) > 0;
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return
     */
    @Override
    public boolean deleteAdminMenuConf(Long menuId) {
        return adminMenuConfEntityMapper.deleteAdminMenuConf(menuId) > 0;
    }
}

package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.AdminMenuConfEntity;
import com.mingqian.domain.vo.menu.MenuListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMenuConfEntityMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(AdminMenuConfEntity record);

    int insertSelective(AdminMenuConfEntity record);

    AdminMenuConfEntity selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(AdminMenuConfEntity record);

    int updateByPrimaryKey(AdminMenuConfEntity record);

    List<MenuListVo> selectAdminParentMenus();

    List<AdminMenuConfEntity> selectAdminChildMenus(@Param("list") List<Long> menuIds);
}
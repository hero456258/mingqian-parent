package com.mingqian.service.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mingqian.domain.vo.menu.MenuListVo;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存相关的工具类
 */
public class CacheUtil {

    public static Cache<Long, List<MenuListVo>> ROLE_MENUS_CACHE = CacheBuilder
            .newBuilder()
            .maximumSize(800)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

    public static Cache<String, String> CAR_ILLEGAL_CITY_CACHE = CacheBuilder
            .newBuilder()
            .maximumSize(10)
            .expireAfterWrite(5, TimeUnit.HOURS)
            .build();

}

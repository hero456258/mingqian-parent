package com.mingqian.dao.mall.mapper;


import com.mingqian.domain.mybatis.entity.AdminAccountEntity;
import org.apache.ibatis.annotations.Param;

public interface AdminAccountEntityMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(AdminAccountEntity record);

    int insertSelective(AdminAccountEntity record);

    AdminAccountEntity selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(AdminAccountEntity record);

    int updateByPrimaryKey(AdminAccountEntity record);

    AdminAccountEntity selectUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
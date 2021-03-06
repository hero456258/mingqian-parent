package com.mingqian.dao.mall.mapper;


import com.mingqian.domain.mybatis.entity.AdminAccountEntity;
import com.mingqian.domain.vo.adminAccount.AdminAccountParamVo;
import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminAccountEntityMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(AdminAccountEntity record);

    int insertSelective(AdminAccountEntity record);

    AdminAccountEntity selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(AdminAccountEntity record);

    int updateByPrimaryKey(AdminAccountEntity record);

    AdminAccountEntity selectUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    List<AdminAccountEntity> selectAdminAccountList(AdminAccountParamVo paramVo);


    int selectAdminAccountCount(AdminAccountParamVo paramVo);

    int insertAdminAccount(AdminAccountVo accountVo);

    AdminAccountEntity selectAdminAccountByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password, @Param("status") String status);

    AdminAccountEntity selectAdminAccountBy(@Param("id") Long id);

    int updateAdminAccount(AdminAccountVo accountVo);

    int updateAdminAccountPassword(@Param("userId") Long userId, @Param("password") String password);

    int deleteAdminAccountBy(@Param("userId") Long userId);
}
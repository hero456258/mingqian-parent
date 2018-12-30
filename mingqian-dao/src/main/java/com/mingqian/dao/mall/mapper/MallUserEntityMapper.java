package com.mingqian.dao.mall.mapper;

import com.mingqian.domain.mybatis.entity.MallUserEntity;
import com.mingqian.domain.vo.mallUser.MallUserParamVo;

import java.util.List;

public interface MallUserEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallUserEntity record);

    int insertSelective(MallUserEntity record);

    MallUserEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallUserEntity record);

    int updateByPrimaryKey(MallUserEntity record);

    List<MallUserEntity> selectMallUserList(MallUserParamVo paramVo);

    Integer selectMallUserListCount(MallUserParamVo paramVo);

    List<MallUserEntity> selectMallUserExcel(MallUserParamVo paramVo);
}
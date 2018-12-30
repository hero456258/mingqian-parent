package com.mingqian.service.mallUser;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.MallUserEntity;
import com.mingqian.domain.vo.mallUser.MallUserParamVo;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * Created by wanggang on 2018/12/30.
 */
public interface MallUserService {
    /**
     * 获取会员列表
     * @param paramVo
     * @return
     */
    PageBean<MallUserEntity> queryMallUserList(MallUserParamVo paramVo);

    /**
     * 导出excel查询会员
     * @param paramVo
     * @return
     */
    List<MallUserEntity> queryMallUserExcel(MallUserParamVo paramVo);

    /**
     * 导出excel
     * @param mallUserEntities
     * @return
     */
    Workbook exportExcel(List<MallUserEntity> mallUserEntities);
}

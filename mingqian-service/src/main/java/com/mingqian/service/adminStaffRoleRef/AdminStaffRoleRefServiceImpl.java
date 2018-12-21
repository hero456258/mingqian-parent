package com.mingqian.service.adminStaffRoleRef;

import com.mingqian.dao.mall.mapper.AdminStaffRoleEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanggang on 2018/12/20.
 */
@Service("adminStaffRoleRef")
public class AdminStaffRoleRefServiceImpl implements AdminStaffRoleRefService {

    @Autowired
    private AdminStaffRoleEntityMapper adminStaffRoleEntityMapper;
    /**
     * 通过userId获取roleId
     *
     * @param userId
     * @return
     */
    @Override
    public Long getRoleId(Long userId) {
        return adminStaffRoleEntityMapper.selectRoleIdBy(userId);
    }
}

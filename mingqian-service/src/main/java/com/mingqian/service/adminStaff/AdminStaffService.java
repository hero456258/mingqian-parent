package com.mingqian.service.adminStaff;

import com.mingqian.domain.mybatis.entity.AdminStaffEntity;

/**
 * Created by wanggang on 2018/12/23.
 */
public interface AdminStaffService {

    /**
     * 通过用户id查询部门id
     * @param userId
     * @return
     */
    Long queryDepartmentId(Long userId);

    boolean addAdminStaff(AdminStaffEntity adminStaffEntity);
}

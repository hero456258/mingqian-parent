package com.mingqian.service.department;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.AdminDepartmentEntity;
import com.mingqian.domain.vo.department.DepartmentListVo;

/**
 * Created by wanggang on 2018/12/19.
 */
public interface DepartmentService {
    /**
     * 获取部门列表
     * @param departmentListVo
     * @return
     */
    PageBean<AdminDepartmentEntity> queryDepartmentList(DepartmentListVo departmentListVo);
}

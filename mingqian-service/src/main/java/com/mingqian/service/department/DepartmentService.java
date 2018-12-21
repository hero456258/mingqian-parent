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

    /**
     * 通过部门id获取部门信息
     * @param id
     * @return
     */
    AdminDepartmentEntity queryDepartmentBy(Long id);

    /**
     * 修改部门信息
     * @param id
     * @param departmentName
     * @param departmentDesc
     * @return
     */
    boolean modifyDepartment(long id, String departmentName, String departmentDesc);

    /**
     * 通过id删除部门
     * @param id
     * @return
     */
    boolean deleteDepartmentBy(Long id);
}

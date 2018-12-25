package com.mingqian.dao.mall.mapper;


import com.mingqian.domain.mybatis.entity.AdminDepartmentEntity;
import com.mingqian.domain.vo.department.DepartmentListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDepartmentEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdminDepartmentEntity record);

    int insertSelective(AdminDepartmentEntity record);

    AdminDepartmentEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminDepartmentEntity record);

    int updateByPrimaryKey(AdminDepartmentEntity record);

    List<AdminDepartmentEntity> selectDepartmentList(DepartmentListVo departmentListVo);

    int selectDepartmentCount(DepartmentListVo departmentListVo);

    AdminDepartmentEntity selectDepartmentBy(@Param("id") Long id);

    int updateDepartment(@Param("id") long id, @Param("departmentName") String departmentName, @Param("departmentDesc") String departmentDesc);

    int deleteDepartmentBy(@Param("id") Long id);

    String selectDepartmentNameBy(@Param("departmentId") Long departmentId);

    List<AdminDepartmentEntity> selectAllDepartments();

    int insertAdminDepartment(AdminDepartmentEntity adminDepartmentEntity);
}
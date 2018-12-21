package com.mingqian.service.department;

import com.mingqian.dao.mall.mapper.AdminDepartmentEntityMapper;
import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.base.PageBeanUtils;
import com.mingqian.domain.mybatis.entity.AdminDepartmentEntity;
import com.mingqian.domain.vo.department.DepartmentListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanggang on 2018/12/19.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private AdminDepartmentEntityMapper adminDepartmentEntityMapper;

    /**
     * 获取部门列表
     *
     * @param departmentListVo
     * @return
     */
    @Override
    public PageBean<AdminDepartmentEntity> queryDepartmentList(DepartmentListVo departmentListVo) {
        System.out.println(departmentListVo.getRowStart());
        List<AdminDepartmentEntity> list = adminDepartmentEntityMapper.selectDepartmentList(departmentListVo);
        int count = adminDepartmentEntityMapper.selectDepartmentCount(departmentListVo);
        return PageBeanUtils.make(list, count);
    }
}

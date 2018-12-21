package com.mingqian.domain.vo.department;


import com.mingqian.domain.base.BasePageVo;

/**
 * Created by wanggang on 2018/12/19.
 */
public class DepartmentListVo extends BasePageVo {
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

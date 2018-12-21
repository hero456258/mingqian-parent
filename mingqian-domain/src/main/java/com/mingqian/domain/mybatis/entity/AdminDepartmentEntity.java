package com.mingqian.domain.mybatis.entity;

import java.util.Date;

/**
 * 
 *
 * @author wanggang
 * @date 2018-12-19
 *
 */
public class AdminDepartmentEntity {
    /** ID */
    private Long id;

    /** 部门名称 */
    private String departmentName;

    /** 部门描述 */
    private String departmentDesc;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 删除状态：0未删除1已删除 */
    private String deleted;

    /** 操作人id */
    private Long caeator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc == null ? null : departmentDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public Long getCaeator() {
        return caeator;
    }

    public void setCaeator(Long caeator) {
        this.caeator = caeator;
    }
}
package com.mingqian.domain.mybatis.entity;

import java.util.Date;

/**
 * 
 *
 * @author admin
 * @date 2018-12-30
 *
 */
public class MallUserEntity {
    /** 主键 */
    private Long id;

    /** 用户名 */
    private String userName;

    /** 用户身份证 */
    private String userCard;

    /** 用户手机哈 */
    private String userMobile;

    /** 用户住址 */
    private String userAddress;

    /** 用户学校 */
    private String userSchool;

    /** 用户专业 */
    private String userSpecialty;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 删除状态 0未删除 1已删除 */
    private String deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard == null ? null : userCard.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool == null ? null : userSchool.trim();
    }

    public String getUserSpecialty() {
        return userSpecialty;
    }

    public void setUserSpecialty(String userSpecialty) {
        this.userSpecialty = userSpecialty == null ? null : userSpecialty.trim();
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
}
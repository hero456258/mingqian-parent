package com.mingqian.domain.vo;


import com.mingqian.domain.base.BasePageVo;

/**
 * Created by tf on 2017/7/7.
 */
public class AdminAccountListVo extends BasePageVo {

    private String loginName;

    private String userId;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

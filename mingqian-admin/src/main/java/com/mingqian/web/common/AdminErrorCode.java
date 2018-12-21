package com.mingqian.web.common;

/**
 * Created by wanggang on 2018/10/17.
 */
public enum AdminErrorCode {
    SYS_ERROR(-1, "系统错误"),

    INPUT_ERROR(-2, "参数错误"),

    OLD_PWD_NOT_MATCH(-3, "密码不匹配!"),

    CHECK_ERROR(-2001, "验证错误!"),

    MEMBERSHIP_NAME(-5,"会员等级名字已存在！"),

    MAIN_CARD_NAME(-6,"卡号已存在！"),

    COMPANY_NAME(-7,"公司名已存在！"),

    DELETE_COMPANY(-8,"删除失败"),

    LOGIN_REPEAT(-3,"用户名重复！"),

    ACCEPT_ERROR(-9,"还有未处理的批次");

    private Integer code;

    private String msg;

    private AdminErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

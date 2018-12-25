package com.mingqian.core.api;

import java.io.Serializable;

/**
 * App基础信息
 */
public class DeviceInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * App版本
     */
    private Integer version;

    /**
     * App平台标识 1 IOS 2 Android 3 H5 4 PC 5 POS 6 其他
     */
    private String deviceNo;

    /**
     * 请求ip地址
     */
    private String ipAddr;

    /**
     * 账户id
     */
    private String accountId;

    /**
     * 令牌
     */
    private String token;

    /**
     * 手机唯一标识码
     */
    private String imei;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}

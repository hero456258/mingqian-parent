package com.mingqian.core.api;

import java.io.Serializable;

/**
 */
public class BaseAppRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    private DeviceInfo device;

    public DeviceInfo getDevice() {
        return device;
    }

    public void setDevice(DeviceInfo device) {
        this.device = device;
    }
}

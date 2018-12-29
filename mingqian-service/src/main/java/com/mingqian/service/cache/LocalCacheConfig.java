package com.mingqian.service.cache;

import java.util.concurrent.TimeUnit;
public enum LocalCacheConfig {

    /**
     * 所有展示的商品列表，键组成：业务方 key + 类目类型
     */
    PERMISSION_CACHE(
            "PermissionCacheService", // 服务名
            1000, // 缓存最大条目数量
            10, TimeUnit.MINUTES, // 10分钟刷新一次
            1, TimeUnit.DAYS // 写入过期时间
    );

    /**
     * 使用方的服务名称，用于区分日志
     */
    private final String serviceName;
    /**
     * 缓存最大条目数量
     */
    private final long maximumSize;
    /**
     * 刷新间隔时间
     */
    private final long refreshAfterWrite;
    /**
     * 刷新间隔时间单位
     */
    private final TimeUnit refreshAfterWriteTimeUnit;
    /**
     * 距离最近一次写入的过期时间
     */
    private final long expireAfterWrite;
    /**
     * 距离最近一次写入的过期时间单位
     */
    private final TimeUnit expireAfterWriteTimeUnit;

    LocalCacheConfig(
            String serviceName,
            long maximumSize,
            long refreshAfterWrite, TimeUnit refreshAfterWriteTimeUnit,
            long expireAfterWrite, TimeUnit expireAfterWriteTimeUnit) {
        this.serviceName = serviceName;
        this.maximumSize = maximumSize;
        this.refreshAfterWrite = refreshAfterWrite;
        this.refreshAfterWriteTimeUnit = refreshAfterWriteTimeUnit;
        this.expireAfterWrite = expireAfterWrite;
        this.expireAfterWriteTimeUnit = expireAfterWriteTimeUnit;
    }

    public String serviceName() {
        return serviceName;
    }

    public long maximumSize() {
        return maximumSize;
    }

    public long refreshAfterWrite() {
        return refreshAfterWrite;
    }

    public TimeUnit refreshAfterWriteTimeUnit() {
        return refreshAfterWriteTimeUnit;
    }

    public long expireAfterWrite() {
        return expireAfterWrite;
    }

    public TimeUnit expireAfterWriteTimeUnit() {
        return expireAfterWriteTimeUnit;
    }

    @Override
    public String toString() {
        return "LocalCacheConfig{" +
                name() + '(' +
                "serviceName='" + serviceName + '\'' +
                ", maximumSize=" + maximumSize +
                ", refreshAfterWrite=" + refreshAfterWrite +
                ", refreshAfterWriteTimeUnit=" + refreshAfterWriteTimeUnit +
                ", expireAfterWrite=" + expireAfterWrite +
                ", expireAfterWriteTimeUnit=" + expireAfterWriteTimeUnit +
                ')' +
                '}';
    }
}

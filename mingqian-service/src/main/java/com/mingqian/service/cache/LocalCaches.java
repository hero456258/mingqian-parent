package com.mingqian.service.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tangfei on 2017/7/31.
 */
public final class LocalCaches {

    private static final Logger logger = LoggerFactory.getLogger(LocalCaches.class);
    /**
     * 共享的任务执行服务
     */
    private static final ExecutorService sharedExecutorService = Executors.newFixedThreadPool(3);

    static {
        Runtime.getRuntime().addShutdownHook(new Thread("CACHE-EXECUTORS-SHUTDOWN-THREAD") {
            public void run() {
                try {
                    logger.info("closing CacheExecutors......");
                    if (!sharedExecutorService.isShutdown()) {
                        sharedExecutorService.shutdown();
                    }
                    logger.info("CacheExecutors has closed......");
                } catch (Exception e) {
                    logger.error("CacheExecutors close error", e);
                }
            }
        });
    }

    /**
     * 创建一个新的可自动加载异步刷新的缓存实例。
     * <p>
     * <p>使用场景：非核心业务。核心业务建议使用“单独的任务执行服务”，使用
     * {@link #newLoadingCache(LocalCacheConfig, CacheLoader, ExecutorService)}。
     * <p>
     * <p><b><font size="7" color="red">
     * 注意：使用“共享的任务执行服务”来异步地重新加载（reload）缓存数据！
     * </font></b>
     *
     * @param config      本地缓存配置
     * @param cacheLoader 同步的缓存加载器
     * @param <K>         键类型
     * @param <V>         值类型
     * @return 一个新的可自动加载异步刷新的缓存实例
     */
    public static <K, V> LoadingCache<K, V> newLoadingCache(
            final LocalCacheConfig config,
            final CacheLoader<K, V> cacheLoader) {
        return newLoadingCache(config, cacheLoader, sharedExecutorService);
    }

    /**
     * 创建一个新的可自动加载异步刷新的缓存实例。
     * <p>
     * <p>使用场景：核心业务。非核心业务建议使用共享的任务执行服务，使用
     * {@link #newLoadingCache(LocalCacheConfig, CacheLoader)}。
     * <p>
     * <p><b><font size="7" color="red">
     * 注意：每次都新创建一个“单独的任务执行服务”来异步地重新加载（reload）缓存数据！
     * </font></b>
     *
     * @param config          本地缓存配置
     * @param cacheLoader     同步的缓存加载器
     * @param executorService 单独的任务执行服务
     * @param <K>             键类型
     * @param <V>             值类型
     * @return 一个新的可自动加载异步刷新的缓存实例
     */
    public static <K, V> LoadingCache<K, V> newLoadingCache(
            final LocalCacheConfig config,
            final CacheLoader<K, V> cacheLoader, final ExecutorService executorService) {

        final LoadingCache<K, V> loadingCache;
        if (config.expireAfterWrite() > 0) {
            loadingCache = CacheBuilder.newBuilder()
                    .maximumSize(config.maximumSize()) // 设置该值，防止缓存内容被撑爆！
                    .refreshAfterWrite(config.refreshAfterWrite(), config.refreshAfterWriteTimeUnit()) // 定期刷新一次
                    .expireAfterWrite(config.expireAfterWrite(), config.expireAfterWriteTimeUnit()) // 在条目被创建或最近替换的值之后定期过期，防止旧值一直存在
                    .recordStats() // 记录缓存性能的累积统计信息
                    .build(CacheLoader.asyncReloading(cacheLoader, executorService));// 封装成异步 reload
        } else {
            loadingCache = CacheBuilder.newBuilder()
                    .maximumSize(config.maximumSize()) // 设置该值，防止缓存内容被撑爆！
                    .refreshAfterWrite(config.refreshAfterWrite(), config.refreshAfterWriteTimeUnit()) // 定期刷新一次
                    .recordStats() // 记录缓存性能的累积统计信息
                    .build(CacheLoader.asyncReloading(cacheLoader, executorService));// 封装成异步 reload
        }
        return loadingCache;
    }
}

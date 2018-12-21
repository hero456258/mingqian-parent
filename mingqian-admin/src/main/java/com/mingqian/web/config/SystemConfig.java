package com.mingqian.web.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * /**
 * 配置文件处理类
 *
 * @author wanggang
 *
 */
public class SystemConfig {

    private static final Logger logger = LogManager.getLogger(SystemConfig.class);

    private static Properties configProperties = new Properties();

    static {
        InputStream is = null;
        try {
            is = SystemConfig.class.getResourceAsStream("/config.properties");
            configProperties.load(is);
            logger.info("加载配置文件config.properties完成......");
        } catch (IOException e) {
            logger.info("加载properties配置文件发生异常，请重启服务再次尝试......");
            e.printStackTrace();
        } finally {
            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                logger.info("加载properties配置文件发生异常，请重启服务再次尝试......");
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取config文件配置参数
     *
     * @param key
     * @return
     */
    public static String getConfigProperty(String key){
        return configProperties.getProperty(key);
    }

    /**
     * 获取config配置文件的所有Key
     *
     * @return
     */
    public static List<String> getConfigPropertyKeys () {
        List<String> urlList = new LinkedList<String>();
        Set<Object> set = configProperties.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            String url = String.valueOf(iterator.next());
            urlList.add(url);
        }
        return urlList;
    }
}

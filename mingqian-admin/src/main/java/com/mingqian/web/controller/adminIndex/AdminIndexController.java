package com.mingqian.web.controller.adminIndex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mingqian.tools.DateUtil;
import com.mingqian.tools.HttpClientUtils;
import com.mingqian.web.config.PropertiesConfig;
import com.mingqian.web.interceptor.annotation.LoginVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by wanggang on 2018/12/20.
 */
@RequestMapping("/adminIndex")
@Controller
@LoginVerify
public class AdminIndexController  {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @RequestMapping("/index")
    public String index(){
        return "/adminIndex/adminIndex";
    }

    @RequestMapping("/getAlmanac")
    @ResponseBody
    public JSONObject getAlmanac(){
        String localDateTime = DateUtil.getLocalDateTime(DateUtil.FORMAT7);
        String url =propertiesConfig.getAlmanac();
        url = MessageFormat.format(url,localDateTime);
        HttpClientUtils hu = new HttpClientUtils();
        String result = null;
        try {
            result = hu.get(url);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(result);
        return jsonObject;
    }

}

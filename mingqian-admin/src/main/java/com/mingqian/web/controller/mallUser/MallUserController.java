package com.mingqian.web.controller.mallUser;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.mybatis.entity.MallUserEntity;
import com.mingqian.domain.vo.mallUser.MallUserParamVo;
import com.mingqian.service.mallUser.MallUserService;
import com.mingqian.web.common.ApiResult;
import com.mingqian.web.common.ApiResulter;
import com.mingqian.web.interceptor.annotation.LoginVerify;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by wanggang on 2018/12/30.
 */
@RequestMapping("/user")
@Controller
@LoginVerify
public class MallUserController {

    private final String FILE_NAME = "会员信息.xls";
    @Resource
    private MallUserService mallUserService;

    @RequestMapping("/userList")
    public String toUserListPage(){
        return "/user/userList";
    }

    @RequestMapping("/userListMessage")
    @ResponseBody
    public ApiResult getUserListMessage(MallUserParamVo paramVo){
        PageBean<MallUserEntity> pages = mallUserService.queryMallUserList(paramVo);
        return ApiResulter.ok(pages);
    }

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response,MallUserParamVo paramVo) throws IOException {
        List<MallUserEntity> mallUserEntities =  mallUserService.queryMallUserExcel(paramVo);
        if(mallUserEntities.size() > 0){
            Workbook workbook = mallUserService.exportExcel(mallUserEntities);
            //设置响应内容类型，因为需要将Excel表格响应回去，所以需要专门设定相应类型
            response.setContentType("octets/stream");
            //设置响应头
            response.addHeader("Content-Disposition", "attachment;fileName=" + new String(FILE_NAME.getBytes("gb2312"), "ISO8859-1"));
            //获取响应流对象
            OutputStream out = response.getOutputStream();
            //将excel写出
            workbook.write(out);
            out.flush();
            //导出完成后关闭流
            out.close();
        }else{
            OutputStream out = response.getOutputStream();
            out.write("无数据".getBytes());
            out.flush();
            //导出完成后关闭流
            out.close();
        }

    }
}

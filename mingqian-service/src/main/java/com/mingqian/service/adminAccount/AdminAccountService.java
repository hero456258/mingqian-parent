package com.mingqian.service.adminAccount;

import com.mingqian.domain.base.PageBean;
import com.mingqian.domain.vo.adminAccount.AdminAccountParamVo;
import com.mingqian.domain.vo.adminAccount.AdminAccountVo;

/**
 * Created by wanggang on 2018/12/20.
 */
public interface AdminAccountService {

    /**
     * 后台用户登录
     * @param userName
     * @param password
     * @return
     */
    AdminAccountVo login(String userName, String password);

    /**
     * 获取用户列表
     * @param paramVo
     * @return
     */
    PageBean<AdminAccountVo> queryAdminAccountList(AdminAccountParamVo paramVo);

    /**
     * 添加用户
     * @param accountVo
     * @return
     */
    boolean addAdminAccount(AdminAccountVo accountVo);

    /**
     * 通过用户id获取用户信息
     * @param id
     * @return
     */
    AdminAccountVo queryAdminAccountBy(Long id);

    /**
     * 修改用户信息
     * @param accountVo
     * @return
     */
    boolean modifyAdminAccount(AdminAccountVo accountVo);
}

package com.mingqian.service.adminAccount;

import com.mingqian.domain.vo.adminAccount.AdminAccountVo;

/**
 * Created by wanggang on 2018/12/20.
 */
public interface AdminAccountService {
    AdminAccountVo login(String userName, String password);
}

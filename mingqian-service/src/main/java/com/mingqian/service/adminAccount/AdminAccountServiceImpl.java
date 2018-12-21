package com.mingqian.service.adminAccount;

import com.mingqian.dao.mall.mapper.AdminAccountEntityMapper;
import com.mingqian.domain.mybatis.entity.AdminAccountEntity;
import com.mingqian.domain.vo.adminAccount.AdminAccountVo;
import com.mingqian.service.adminStaffRoleRef.AdminStaffRoleRefService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanggang on 2018/12/20.
 */
@Service("adminAccountService")
public class AdminAccountServiceImpl implements AdminAccountService {

    @Autowired
    private AdminAccountEntityMapper adminAccountEntityMapper;

    @Autowired
    private AdminStaffRoleRefService adminStaffRoleRefService;
    @Override
    public AdminAccountVo login(String userName, String password) {

        AdminAccountEntity adminAccountEntity = adminAccountEntityMapper.selectUserByUserNameAndPassword(userName, password);
        if(null == adminAccountEntity){
            return null;
        }
        AdminAccountVo adminAccountVo = new AdminAccountVo();
        BeanUtils.copyProperties(adminAccountEntity,adminAccountVo);
        adminAccountVo.setRoleId(adminStaffRoleRefService.getRoleId(adminAccountVo.getUserId()));
        return adminAccountVo;
    }
}

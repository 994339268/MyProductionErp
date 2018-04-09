package org.erp.myproductionsrc.service.impl;

import org.erp.myproductionsrc.domain.authority.SysUser;
import org.erp.myproductionsrc.mapper.authority.SysUserDao;
import org.erp.myproductionsrc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    public List<SysUser> findAllUser() {
        return sysUserDao.findAllUser();
    }

    public SysUser findUserByName(String username) {
        return sysUserDao.findUserByName(username);
    }
}

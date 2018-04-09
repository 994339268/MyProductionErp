package org.erp.myproductionsrc.service;

import org.erp.myproductionsrc.domain.authority.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> findAllUser();

    SysUser findUserByName(String username);
}

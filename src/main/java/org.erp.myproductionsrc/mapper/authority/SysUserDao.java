package org.erp.myproductionsrc.mapper.authority;

import org.erp.myproductionsrc.domain.authority.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SysUserDao {

    List<SysUser> findAllUser();

    SysUser findUserByName(String username);
}

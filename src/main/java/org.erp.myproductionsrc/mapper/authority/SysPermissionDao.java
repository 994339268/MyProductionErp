package org.erp.myproductionsrc.mapper.authority;

import org.erp.myproductionsrc.domain.authority.SysPermission;

import java.util.List;

public interface SysPermissionDao {

    List<SysPermission> findPermission(String ids[]);
}

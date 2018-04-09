package org.erp.myproductionsrc.service;

import org.erp.myproductionsrc.domain.authority.SysPermission;

import java.util.List;

public interface SysPermissionService {

    List<SysPermission> findPermission(String ids[]);
}

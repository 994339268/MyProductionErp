package org.erp.myproductionsrc.service.impl;

import org.erp.myproductionsrc.domain.authority.SysPermission;
import org.erp.myproductionsrc.mapper.authority.SysPermissionDao;
import org.erp.myproductionsrc.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionDao sysPermissionDao;

    public List<SysPermission> findPermission(String[] ids) {

        return sysPermissionDao.findPermission(ids);
    }
}

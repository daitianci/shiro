package com.honor.shiro.service.impl;

import com.honor.shiro.dao.PermissionDao;
import com.honor.shiro.dao.impl.PermissionDaoImpl;
import com.honor.shiro.entity.Permission;
import com.honor.shiro.service.PermissionService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}

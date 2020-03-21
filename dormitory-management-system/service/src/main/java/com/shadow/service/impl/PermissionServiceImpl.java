package com.shadow.service.impl;


import com.shadow.entity.Permission;
import com.shadow.entity.Role;
import com.shadow.entity.RolePermission;
import com.shadow.repo.*;
import com.shadow.service.PermissionService;
import com.shadow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserRoleRepo userRoleRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    RolePermissionRepo rolePermissionRepo;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionRepo permissionRepo;

    @Override
    public boolean needInterceptor(String url) {
        List<Permission> permissionList = permissionRepo.getAllByUrl(url);
        if (permissionList.size()>0)
            return true;
        return false;
    }

    @Override
    public Set<String> listPermissions(String sid) {
        List<Role> roleList = roleService.listRoleBySid(sid);
        List<RolePermission> rolePermissionList = new ArrayList<>();
        roleList.forEach(
                role -> {
                    rolePermissionList.addAll(rolePermissionRepo.findByRid(role.getId()));
                }
        );
        List<Permission> permissionList = new ArrayList<>();
        rolePermissionList.forEach(
                rolePermission -> {
                    permissionList.addAll(permissionRepo.getAllById(rolePermission.getPid()));
                }
        );
        Set<String> result = new HashSet<>();
        permissionList.forEach(
                permission -> {
                    result.add(permission.getUrl());
                }
        );
        return result;
    }
}

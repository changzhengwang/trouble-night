package com.shadow.service.impl;


import com.shadow.entity.Role;
import com.shadow.entity.User;
import com.shadow.entity.UserRole;
import com.shadow.repo.RoleRepo;
import com.shadow.repo.UserRepo;
import com.shadow.repo.UserRoleRepo;
import com.shadow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserRoleRepo userRoleRepo;
    @Autowired
    RoleRepo roleRepo;

    @Override
    public Set<String> listRoleNames(String sid) {

        List<Role> roleList = listRoleBySid(sid);
        Set<String> result = new HashSet<>();
        roleList.forEach(
                role -> {
                    result.add(role.getName());
                }
        );
        return result;
    }

    @Override
    public List<Role> listRoleBySid(String sid) {
        User user = userRepo.findBySid(sid).get(0);
        List<UserRole>  userRoleList = userRoleRepo.findByUid(user.getId());
        List<Role> roleList = new ArrayList<>();
        userRoleList.forEach(
                userRole -> {
                    roleList.addAll(roleRepo.findById(userRole.getRid()));
                }
        );
        return roleList;
    }
}

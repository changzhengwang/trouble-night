package com.shadow.service;

import com.shadow.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface RoleService {

    List<Role> listRoleBySid(String sid);

    Set<String> listRoleNames(String sid);
}

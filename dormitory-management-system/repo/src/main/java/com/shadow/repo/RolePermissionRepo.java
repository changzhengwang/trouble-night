package com.shadow.repo;

import com.shadow.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RolePermissionRepo extends JpaRepository<RolePermission,Integer> {
    Collection<? extends RolePermission> findByRid(int rid);
}

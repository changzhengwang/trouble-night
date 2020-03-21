package com.shadow.repo;

import com.shadow.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PermissionRepo extends JpaRepository<Permission,Integer> {

    Collection<? extends Permission> getAllById(int id);

    List<Permission> getAllByUrl(String url);
}

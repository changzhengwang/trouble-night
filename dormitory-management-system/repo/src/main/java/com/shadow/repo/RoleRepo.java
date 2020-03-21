package com.shadow.repo;

import com.shadow.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {

    Collection<? extends Role> findById(int id);
}

package com.shadow.repo;

import com.shadow.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Integer> {

    List<UserRole> findByUid(int uid);

}

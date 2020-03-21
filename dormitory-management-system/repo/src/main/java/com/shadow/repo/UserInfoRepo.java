package com.shadow.repo;


import com.shadow.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {

    UserInfo getFirstByUid(int uid);
}

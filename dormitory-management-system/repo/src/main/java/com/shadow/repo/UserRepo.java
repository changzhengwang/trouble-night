package com.shadow.repo;

import com.shadow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User getFirstById(int id);

    List<User> findBySid(String sid);

    List<User> findBySign(int sign);

}

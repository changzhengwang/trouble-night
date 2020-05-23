package com.shadow.service;

import com.shadow.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserService {

    User findUserBySid(String sid);

    List<User> selectByDormId(String dormId);
}

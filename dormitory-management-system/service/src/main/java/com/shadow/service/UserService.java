package com.shadow.service;

import com.shadow.entity.User;
import org.springframework.stereotype.Component;


@Component
public interface UserService {

    User findUserBySid(String sid);

}

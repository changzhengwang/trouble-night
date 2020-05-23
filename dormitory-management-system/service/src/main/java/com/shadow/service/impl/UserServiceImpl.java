package com.shadow.service.impl;


import com.shadow.entity.User;
import com.shadow.mapper.UserMapper;
import com.shadow.repo.UserRepo;
import com.shadow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectByDormId(String dormId) {
        return userMapper.selectByDormId(dormId);
    }

    @Override
    public User findUserBySid(String sid) {
        List<User> userList = userRepo.findBySid(sid);
        if (userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

}

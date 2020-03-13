package com.shadow.controller;

import com.shadow.entity.User;
import com.shadow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    List<User> getUsers(){
        return userService.getUsers();
    }

}

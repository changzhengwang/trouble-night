package com.shadow.controller;



import com.shadow.entity.Msg;
import com.shadow.entity.User;
import com.shadow.entity.UserInfo;
import com.shadow.repo.UserInfoRepo;
import com.shadow.repo.UserRepo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserInfoRepo userInfoRepo;

    @GetMapping("/login2")
    public Msg login2(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password, HttpServletRequest request) {
        HttpSession mysession =request.getSession();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return Msg.success();

        } catch (AuthenticationException e) {
            return Msg.fail();
        }
    }

    @PostMapping("/login")
    public Msg login(@RequestBody User user, HttpServletRequest request) {
        HttpSession mysession =request.getSession();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getSid(), user.getPassword());
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            User user1 = userRepo.findBySid(user.getSid()).get(0);
            user1.setPassword(null);
            user1.setSign(0);
            user1.setSalt(null);
            UserInfo userInfo = userInfoRepo.getFirstByUid(user1.getId());
            return Msg.success().add("user",user1).add("userInfo",userInfo);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Msg.fail();
        }
    }

    @PostMapping("/logout")
    public Msg logout() {
            return Msg.success();
    }
}

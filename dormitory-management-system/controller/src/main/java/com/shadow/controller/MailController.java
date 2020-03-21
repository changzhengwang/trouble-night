package com.shadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/send")
    public String send(){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("happ123kobe@163.com");
        //接收者
        mainMessage.setTo("18736268016@163.com");
        //发送的标题
        mainMessage.setSubject("王长征测试邮件发送");
        //发送的内容
        mainMessage.setText("接口发送成功");
        javaMailSender.send(mainMessage);
        return "接口发送成功";
    }
}

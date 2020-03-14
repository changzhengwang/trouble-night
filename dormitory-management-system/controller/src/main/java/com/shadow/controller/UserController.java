package com.shadow.controller;

import com.google.gson.Gson;
import com.shadow.entity.User;
import com.shadow.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("sendSms")
    public String sendSys() {
        // 短信平台接口地址
		String url = "http://msgplat.sywgqh.com.cn:8383/msgplat/sms";// 外网访问地址
        //String url = "http://180.2.255.27:8383/msgplat/sms";// 内网访问地址
        // 设置短信各参数
        Map<String, Object> map = new HashMap<>();
        // 分配的账号
        map.put("account", "luqs");
        // 分配的账号密码
        map.put("password", "123456");
        // 短信定时发送时间。如果想立即发送，可不设置此参数或参数值为空。时间格式为yyyy-MM-dd HH:mm:ss
        map.put("timingDtt", "2020-03-213 15:34:00");
        // 短信收件人。多个手机号用英文分号分隔
        map.put("receiverMobile", "13523638147");
        // 短信正文
        map.put("content", "金仕达向上适当性");

        // post发送
        String res = HttpClientUtil.doPostJson(url, new Gson().toJson(map));
        return res;

    }
}

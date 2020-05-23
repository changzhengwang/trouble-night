package com.shadow.controller;

import com.google.gson.Gson;
import com.shadow.entity.Msg;
import com.shadow.entity.User;
import com.shadow.repo.UserInfoRepo;
import com.shadow.repo.UserRepo;
import com.shadow.service.PermissionService;
import com.shadow.service.UserService;


import com.shadow.utils.HttpClientUtil;
import com.shadow.utils.RespUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserInfoRepo userInfoRepo;
    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;

    @GetMapping("/getUsersByDormId")
    public RespUtil getUsersByDormId(@RequestParam("dormId")String dormId){
        return RespUtil.success().data(userService.selectByDormId(dormId));
    }

    @GetMapping("/getUserById")
    public RespUtil getUserWithInfoById(@RequestParam("id")int id){
        return RespUtil.success().data(userRepo.findById(id));
    }

    @GetMapping("/getUserInfoByUId")
    public RespUtil getUserInfoByUId(@RequestParam("id")int id){
        return RespUtil.success().data(userInfoRepo.getFirstByUid(id));
    }

    @GetMapping("/getPermissions")
    public Msg getAllMyPermission(){
        Subject subject = SecurityUtils.getSubject();
        String userName = subject.getPrincipal().toString();
        Set<String> permissions = permissionService.listPermissions(userName);
        return Msg.success().add("list",permissions);
    }


    @GetMapping("/getOneByName")
    public List<User> getOne(){
        List<User> userList = userRepo.findBySign(1);
        return userRepo.findBySid("wcz");
    }


    @GetMapping("sendSms")
    public String sendSys() {
        // 短信平台接口地址
		String url = "http://devtest.sywgqh.com.cn:18080/msgplat/sms";// 外网访问地址
        //String url = "http://180.2.255.27:8383/msgplat/sms";// 内网访问地址
        // 设置短信各参数
        Map<String, Object> map = new HashMap<>();
        // 分配的账号
        map.put("account", "test");
        // 分配的账号密码
        map.put("password", "111111");
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

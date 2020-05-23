package com.shadow.controller;

import com.shadow.service.DormService;
import com.shadow.utils.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author WCZ
 * @date 2020-05-18
 * @Description:
 **/
@RestController
public class DormController {
    @Autowired
    DormService dormService;

    @GetMapping("/getDorm")
    public RespUtil getDorm(@RequestParam("dormitoryId")String dormitoryId,@RequestParam("name") String name){
        return RespUtil.success().data(dormService.selectDorm(dormitoryId,name));
    }

    @GetMapping("/getDormById")
    public RespUtil getDormById(@RequestParam("id")String id){
        return RespUtil.success().data(dormService.selectById(id));
    }
}

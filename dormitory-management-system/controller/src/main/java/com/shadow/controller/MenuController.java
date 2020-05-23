package com.shadow.controller;

import com.shadow.entity.Menu;
import com.shadow.service.MenuService;
import com.shadow.utils.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WCZ
 * @date 2020-03-29
 * @Description:
 **/
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping("/getMenus")
    public RespUtil getMenus(){
        List<Menu> menuList = menuService.getMenus();
        return RespUtil.success().data(menuList);
    }
}

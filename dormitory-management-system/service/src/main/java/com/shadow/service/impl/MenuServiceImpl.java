package com.shadow.service.impl;

import com.shadow.entity.Menu;
import com.shadow.repo.MenuRepo;
import com.shadow.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WCZ
 * @date 2020-03-29
 * @Description:
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepo menuRepo;

    @Override
    public List<Menu> getMenus() {
        List<Menu> menuList = menuRepo.findAll();
        return menuList;
    }
}

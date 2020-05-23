package com.shadow.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author WCZ
 * @date 2020-03-29
 * @Description:
 **/
@Data
@Entity(name="menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "icon")
    private String icon;

    @Column(name = "index")
    private String index;

    @Column(name = "title")
    private String title;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "f_id")
    private int fId;

    @Column(name = "level")
    private int level;

    @Column(name = "menu_type")
    private char menuType;

    @Transient
    private List<Menu> subs;

}

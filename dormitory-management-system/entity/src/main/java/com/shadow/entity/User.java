package com.shadow.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sid")
    private String sid;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;


    @Column(name="salt")
    private String salt;

    @Column(name = "type")
    private char sign;

    @Column(name = "createdate")
    private Date createdate;

    @Column(name = "dorm_id")
    private String dormId;

    @Column(name = "on_school")
    private String onSchool;
}

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

    @Column(name = "idcard")
    private String idcard;

    @Column(name="salt")
    private String salt;

    @Column(name = "sign")
    private int sign;

    @Column(name = "createdate")
    private Date createdate;
}

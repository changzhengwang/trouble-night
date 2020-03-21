package com.shadow.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity(name = "user_info")
public class UserInfo {

    @Id
    @Column(name = "uid")
    private int uid;

    @Column(name = "in_no")
    private String idNo;

    @Column(name = "gender")
    private char gender;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String procince;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "birth")
    private String birth;

    @Column(name = "created_ps")
    private String createdPs;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "image")
    private String image;
}

package com.shadow.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "frontcut")
    private String frontcut;

    @Column(name = "createdtime")
    private Date createdtime;

    @Column(name = "createdps")
    private String createdps;

    @Column(name = "alltext")
    private String alltext;

    @Column(name = "texttype")
    private int texttype;
}

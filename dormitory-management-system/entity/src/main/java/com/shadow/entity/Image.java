package com.shadow.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name = "images")
public class Image {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "url")
    private String url;

    @Column(name = "upload_time")
    private Date uploadTime;

    @Column(name = "imege_type")
    private String imageType;
}

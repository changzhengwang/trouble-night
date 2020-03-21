package com.shadow.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;

    @Column(name = "name")
	private String name;

    @Column(name = "describes")
	private String describes;

}
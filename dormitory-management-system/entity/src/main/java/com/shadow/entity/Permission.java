package com.shadow.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "describes")
	private String describes;

	@Column(name = "url")
	private String url;

}
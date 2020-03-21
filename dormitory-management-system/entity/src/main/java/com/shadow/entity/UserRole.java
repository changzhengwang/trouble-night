package com.shadow.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "uid")
	private int uid;

	@Column(name = "rid")
	private int rid;

}
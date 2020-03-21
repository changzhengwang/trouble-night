package com.shadow.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "role_permission")
public class RolePermission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "rid")
	private int rid;

	@Column(name = "pid")
	private int pid;

}
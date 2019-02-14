package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_manager")
public class Manager {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=30)
	private String name;

	@Column(length=30)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Manager(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Manager(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public Manager() {
		super();
	}

}

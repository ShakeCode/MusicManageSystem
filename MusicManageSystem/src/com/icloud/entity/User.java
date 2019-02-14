
package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="t_user")
public class User {

	@Id
	@GeneratedValue
	private int id;

	@Column(length=30)
	private String name;

	@Column(length=30)
	private String password;
	
	@Column(length=30)
	private String nickname;
	
	@Column(length=5)
	private String sex;

	@Column(length=15)
	private String qq;

	@Column(length=30)
	private String email;
	
	@Column(length=255)
	private String introduction;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String password, String nickname, String sex, String qq, String email,
			String introduction) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.qq = qq;
		this.email = email;
		this.introduction = introduction;
	}

	public User(String name, String password, String nickname, String sex, String qq, String email,
			String introduction) {
		super();
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.qq = qq;
		this.email = email;
		this.introduction = introduction;
	}
	
}

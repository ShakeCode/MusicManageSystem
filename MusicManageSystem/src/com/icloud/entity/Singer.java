package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_singer")
public class Singer {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=255)
	private String name;

	@Column(length=5)
	private String sex;
	
	@Column
	private int views;
	
	@Column(length=255)
	private String hobby;
	
	@Column(length=20)
	private String type;
	
	@Column
	private String photoName;  //歌手图片地址
	
	@Column
	private String introduce;  //歌手介绍
	
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Singer(int id, String name, String sex, int views, String hobby, String type,String introduce) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.views = views;
		this.hobby = hobby;
		this.type = type;
		this.introduce = introduce;
	}

	public Singer(String name, String sex, int views, String hobby) {
		super();
		this.name = name;
		this.sex = sex;
		this.views = views;
		this.hobby = hobby;
	}

	public Singer(int id, String name, String sex, int views, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.views = views;
		this.hobby = hobby;
	}

	public Singer(String name, String sex, int views, String hobby, String type,String introduce , String photoName) {
		super();
		this.name = name;
		this.sex = sex;
		this.views = views;
		this.hobby = hobby;
		this.type = type;
		this.photoName = photoName;
		this.introduce = introduce;
	}
	public Singer(String name, String sex, int views, String hobby, String type, String photoName) {
		super();
		this.name = name;
		this.sex = sex;
		this.views = views;
		this.hobby = hobby;
		this.type = type;
		this.photoName = photoName;
	}
	public Singer(int id, String name, String sex, int views, String hobby, String type,String introduce, String photoName) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.views = views;
		this.hobby = hobby;
		this.type = type;
		this.introduce = introduce;
		this.photoName = photoName;
	}
	
	public Singer() {
		super();
	}
}

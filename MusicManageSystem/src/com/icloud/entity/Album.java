package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_album")
public class Album {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=50)
	private String singer;
	
	@Column
	private int views;
	
	@Column(length=50)
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

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Album(int id, String name, String singer, int views, String introduction) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.views = views;
		this.introduction = introduction;
	}

	public Album(String name, String singer, int views, String introduction) {
		super();
		this.name = name;
		this.singer = singer;
		this.views = views;
		this.introduction = introduction;
	}

	public Album() {
		super();
	}
	
}

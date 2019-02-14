package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_songlist")
public class SongList {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private int userID;

	@Column
	private int songID;
	
	@Column(length=50)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

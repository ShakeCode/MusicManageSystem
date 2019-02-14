package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_lyc")
public class Lyc {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=50)
	private String lycName;
	
	@Column(length=255)
	private String songName;
	@Column
	private int songID;
	
	@Column(length=255)
	private String lycURL;
	
	@Column(length=255)
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLycName() {
		return lycName;
	}

	public void setLycName(String lycName) {
		this.lycName = lycName;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getLycURL() {
		return lycURL;
	}

	public void setLycURL(String lycURL) {
		this.lycURL = lycURL;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

	public Lyc(int id, String lycName, String songName, int songID, String lycURL, String author) {
		super();
		this.id = id;
		this.lycName = lycName;
		this.songName = songName;
		this.songID = songID;
		this.lycURL = lycURL;
		this.author = author;
	}

	
	public Lyc(String lycName, String songName, int songID, String lycURL, String author) {
		super();
		this.lycName = lycName;
		this.songName = songName;
		this.songID = songID;
		this.lycURL = lycURL;
		this.author = author;
	}

	public Lyc() {
		super();
	}
}

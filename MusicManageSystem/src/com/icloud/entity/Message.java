package com.icloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_message")
public class Message {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=2000)
	private String contant;
	
	@Column
	private Integer songID;
	
	@Column
	private String status;
	
	@Column
	private Date createTime;
	
	@Column
	private Date updatedTime;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContant() {
		return contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

	public Integer getSongID() {
		return songID;
	}

	public void setSongID(Integer songID) {
		this.songID = songID;
	}

	public Message(int id, String contant, int songID) {
		super();
		this.id = id;
		this.contant = contant;
		this.songID = songID;
	}

	public Message(int id, String contant, int songID, String status, Date createTime, Date updatedTime) {
		super();
		this.id = id;
		this.contant = contant;
		this.songID = songID;
		this.status = status;
		this.createTime = createTime;
		this.updatedTime = updatedTime;
	}

	public Message(String contant, int songID) {
		super();
		this.contant = contant;
		this.songID = songID;
	}

	public Message() {
		super();
	}
	
}

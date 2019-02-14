package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_songType")
public class SongType {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=50)
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public SongType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public SongType() {
		super();
	}
	
	
}

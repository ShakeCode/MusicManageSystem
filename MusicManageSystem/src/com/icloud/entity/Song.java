package com.icloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="t_song")
public class Song {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=255)
	private String songName;
	
	@Column(length=255)
	private String singer;
	
	@Column(length=255)
	private String album;
	
	@Column(length=50)
	private String typeName;
	 
	@Column(length=50)
	private String fileSize;
	
	@Column(length=255)
	private String fileURL;
	
	@Column(length=10)
	private String format;
	
	@Column
	private Integer hits;
	
	@Column
	private Integer download;
	
	@Column
	private String playTime;

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getDownload() {
		return download;
	}

	public void setDownload(int download) {
		this.download = download;
	}

	public Song(int id, String songName, String singer, String album, String typeName, String fileSize, String fileURL,
			String format, Integer hits, Integer download) {
		super();
		this.id = id;
		this.songName = songName;
		this.singer = singer;
		this.album = album;
		this.typeName = typeName;
		this.fileSize = fileSize;
		this.fileURL = fileURL;
		this.format = format;
		this.hits = hits;
		this.download = download;
	}

	
	public Song(String songName, String singer, String album, String typeName, String fileSize, String fileURL,
			String format, int hits, int download) {
		super();
		this.songName = songName;
		this.singer = singer;
		this.album = album;
		this.typeName = typeName;
		this.fileSize = fileSize;
		this.fileURL = fileURL;
		this.format = format;
		this.hits = hits;
		this.download = download;
	}

	public Song(int id, String songName, String singer, String album, String typeName, String fileSize, String fileURL,
			String format,String playTime, int hits, int download) {
		super();
		this.id = id;
		this.songName = songName;
		this.singer = singer;
		this.album = album;
		this.typeName = typeName;
		this.fileSize = fileSize;
		this.fileURL = fileURL;
		this.format = format;
		this.hits = hits;
		this.download = download;
		this.playTime = playTime;
	}

	
	public Song(String songName, String singer, String album, String typeName, String fileSize, String fileURL,
			String format,String playTime, int hits, int download) {
		super();
		this.songName = songName;
		this.singer = singer;
		this.album = album;
		this.typeName = typeName;
		this.fileSize = fileSize;
		this.fileURL = fileURL;
		this.format = format;
		this.hits = hits;
		this.download = download;
		this.playTime = playTime;
	}
	public Song() {
		super();
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", singer=" + singer + ", album=" + album + ", typeName="
				+ typeName + ", fileSize=" + fileSize + ", fileURL=" + fileURL + ", format=" + format + ", hits=" + hits
				+ ", download=" + download + ", playTime=" + playTime + "]";
	}
}

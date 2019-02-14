package com.icloud.service;

import java.util.List;

import com.icloud.entity.SongType;

public interface SongTypeService {
	
	public SongType getSongType(int id);

	public List<SongType> getAllSongType();

	public int addSongType(SongType songtype);

	public boolean delSongType(int id);

}

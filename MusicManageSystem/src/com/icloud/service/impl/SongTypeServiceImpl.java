package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.SongTypeDao;
import com.icloud.entity.SongType;
import com.icloud.service.SongTypeService;

public class SongTypeServiceImpl implements SongTypeService{
	private SongTypeDao songTypeDao;

	public void setSongTypeDao(SongTypeDao songTypeDao) {
		this.songTypeDao = songTypeDao;
	}

	@Override
	public SongType getSongType(int id) {
		return songTypeDao.getSongType(id);
	}

	@Override
	public List<SongType> getAllSongType() {
		return songTypeDao.getAllSongType();
	}

	@Override
	public int addSongType(SongType songtype) {
		return songTypeDao.addSongType(songtype);
	}

	@Override
	public boolean delSongType(int id) {
		return songTypeDao.delSongType(id);
	}


}

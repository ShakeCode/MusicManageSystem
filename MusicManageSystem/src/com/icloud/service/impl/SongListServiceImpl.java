package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.SongListDao;
import com.icloud.entity.Song;


public class SongListServiceImpl implements SongListDao{
	private SongListDao songListDao;

	public void setSongListDao(SongListDao songListDao) {
		this.songListDao = songListDao;
	}

	@Override
	public List<Song> selectSongListByUserName(String username) {
		return songListDao.selectSongListByUserName(username);
	}
}

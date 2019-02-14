package com.icloud.dao;

import java.util.List;

import com.icloud.entity.Song;

public interface SongListDao {

	public List<Song> selectSongListByUserName(String username);
}

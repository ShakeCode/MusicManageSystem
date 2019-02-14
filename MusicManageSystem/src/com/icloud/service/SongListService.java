package com.icloud.service;

import java.util.List;

import com.icloud.entity.Song;

public interface SongListService {

	public List<Song> selectSongListByUserName(String username);

}

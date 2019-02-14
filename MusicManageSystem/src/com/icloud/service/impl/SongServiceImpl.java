package com.icloud.service.impl;

import java.util.List;
import java.util.Map;

import com.icloud.dao.SongDao;
import com.icloud.entity.Pager;
import com.icloud.entity.Singer;
import com.icloud.entity.Song;
import com.icloud.entity.SongList;
import com.icloud.service.SongService;

public class SongServiceImpl implements SongService{
	private SongDao songDao;

	public void setSongDao(SongDao songDao) {
		this.songDao = songDao;
	}

	@Override
	public Song getSong(int id) {
		return songDao.getSong(id);
	}

	@Override
	public List<Song> getAllSong() {
		return songDao.getAllSong();
	}

	@Override
	public List<Song> getAllSongByType(String typeName) {
		return songDao.getAllSongByType(typeName);
	}

	@Override
	public int addSong(Song song) {
		return songDao.addSongr(song);
	}

	@Override
	public boolean delSong(int id) {
		return songDao.delSongr(id);
	}

	@Override
	public boolean updateSong(Song song) {
		return songDao.updateSongr(song);
	}

	//��ѯ���а�
	@Override
	public List<Song> selectRankingListByType(String type) {
		
		return songDao.selectRankingListByType(type);
	}

	@Override
	public Pager selectSongListByUserName(String username,Integer pageIndex,Integer pageSize) {
		return songDao.selectSongListByUserName(username, pageIndex, pageSize);
		
	}

	@Override
	public List<Song> selectSongListBySongName(String songName) {
		// TODO Auto-generated method stub
		return songDao.selectSongListBySongName(songName);
	}

	@Override
	public Pager selectSongListBySinger(String singer,Integer pageIndex,Integer pageSize) {
		// TODO Auto-generated method stub
		return songDao.selectSongListBySinger(singer, pageIndex, pageSize);
	}

	@Override
	public List<Singer> selectSingerListByName(String name) {
		// TODO Auto-generated method stub
		return songDao.selectSingerListByName(name);
	}

	@Override
	public Pager selectSongListByType(String type,Integer pageIndex,Integer pageSize) {
		// TODO Auto-generated method stub
		return songDao.selectSongListByType(type, pageIndex, pageSize);
	}

	@Override
	public Pager selectSingerListByType(String type,Integer pageIndex,Integer pageSize){
		// TODO Auto-generated method stub
		
		return songDao.selectSingerListByType(type, pageIndex, pageSize);
	}

	@Override
	public Integer AddSongListByUserIdAndSongId(Integer userID, Integer songID) {
		// TODO Auto-generated method stub
		return songDao.AddSongListByUserIdAndSongId(userID, songID);
	}

	@Override
	public Boolean deleteSongList(Integer userID, Integer songID) {
		// TODO Auto-generated method stub
		return songDao.deleteSongList(userID, songID);
	}

	@Override
	public Song selectSongById(Integer id) {
		// TODO Auto-generated method stub
		return songDao.selectSongById(id);
	}

	@Override
	public boolean updateSongHitOrDownLoad(Integer id, Integer hit, Integer download) {
		
		return songDao.updateSongHitOrDownLoad(id,hit, download);
	}

	@Override
	public List<Singer> selectSingerListById(Integer id) {
		return songDao.selectSingerListById(id);
	}

	@Override
	public List<Singer> selectSingerListByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SongList> selectSongListByIdAndUserId(Integer songId, Integer userId) {
		
		return songDao.selectSongListByIdAndUserId(songId, userId);
	}
	
	
}

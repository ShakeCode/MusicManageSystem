package com.icloud.service;

import java.util.List;
import java.util.Map;

import com.icloud.entity.Pager;
import com.icloud.entity.Singer;
import com.icloud.entity.Song;
import com.icloud.entity.SongList;

public interface SongService {
	public Song getSong(int id);

	public List<Song> getAllSong();
	
	public List<Song> getAllSongByType(String typeName);

	public int addSong(Song song);

	public boolean delSong(int id);

	public boolean updateSong(Song song);
	
	public boolean updateSongHitOrDownLoad(Integer id,Integer hit, Integer download);
	//��ѯ���а�
	public List<Song> selectRankingListByType(String type);
	
	//�����б�
	public Pager selectSongListByUserName(String username,Integer pageIndex,Integer pageSize);
	
	//���ݸ��������ֲ�ѯ����
	public List<Song> selectSongListBySongName(String songName);
	
	public Pager selectSongListBySinger(String singer,Integer pageIndex,Integer pageSize);
	
	//ģ����ѯ�����б�
	public List<Singer> selectSingerListByName(String name);
	
	//�������Ͳ�ѯ�����б�
	public Pager selectSongListByType(String type,Integer pageIndex,Integer pageSize);
	
	////�������Ͳ�ѯ�����б�
	public List<Singer> selectSingerListByType(String type);
	
	//��Ӳ����б�һ����������
	public Integer AddSongListByUserIdAndSongId(Integer userID , Integer songID);
	
	//ɾ�������б�һ����������
	public Boolean deleteSongList(Integer userID , Integer songID);
	
	public Pager selectSingerListByType(String type,Integer pageIndex,Integer pageSize);
	//����id��ѯ������Ϣ
	public Song selectSongById(Integer id);
	
	public List<Singer> selectSingerListById(Integer id);
	
	public List<SongList> selectSongListByIdAndUserId(Integer songId,Integer userId);
}

package com.icloud.dao;

import java.util.List;

import com.icloud.entity.Singer;

public interface SingerDao {

	public Singer getSinger(int id);

	public List<Singer> getAllSinger();

	public int addSinger(Singer singer);

	public boolean delSinger(int id);

	public boolean updateSinger(Singer singer);
	
	public Singer getSingerByName(String name);
}

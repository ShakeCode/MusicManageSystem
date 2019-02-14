package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.SingerDao;
import com.icloud.entity.Singer;
import com.icloud.service.SingerService;

public class SingerServiceImpl implements SingerService{
	private SingerDao singerDao;

	public void setSingerDao(SingerDao singerDao) {
		this.singerDao = singerDao;
	}

	@Override
	public Singer getSinger(int id) {
		return singerDao.getSinger(id);
	}

	@Override
	public List<Singer> getAllSinger() {
		return singerDao.getAllSinger();
	}

	@Override
	public int addSinger(Singer singer) {
		return singerDao.addSinger(singer);
	}

	@Override
	public boolean delSinger(int id) {
		return singerDao.delSinger(id);
	}

	@Override
	public boolean updateSinger(Singer singer) {
		return singerDao.updateSinger(singer);
	}
	@Override
	public Singer getSingerByName(String Name) {
		return singerDao.getSingerByName(Name);
	}
}

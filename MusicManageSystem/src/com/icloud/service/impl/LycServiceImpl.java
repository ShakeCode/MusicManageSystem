package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.LycDao;
import com.icloud.entity.Lyc;
import com.icloud.service.LycService;

public class LycServiceImpl implements LycService{
	private LycDao lycDao;

	public void setLycDao(LycDao lycDao) {
		this.lycDao = lycDao;
	}

	@Override
	public Lyc getLyc(int id) {
		return lycDao.getLyc(id);
	}

	@Override
	public List<Lyc> getAllLyc() {
		return lycDao.getAllLyc();
	}

	@Override
	public int addLyc(Lyc lyc) {
		return lycDao.addLyc(lyc);
	}

	@Override
	public boolean delLyc(int id) {
		return lycDao.delLyc(id);
	}

	@Override
	public boolean updateLyc(Lyc lyc) {
		return lycDao.updateLyc(lyc);
	}
}

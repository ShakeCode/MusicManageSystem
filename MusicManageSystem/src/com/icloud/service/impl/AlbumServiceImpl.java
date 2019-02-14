package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.AlbumDao;
import com.icloud.entity.Album;
import com.icloud.service.AlbumService;

public class AlbumServiceImpl implements AlbumService{
	private AlbumDao albumDao;

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	@Override
	public Album getAlbum(int id) {
		return albumDao.getAlbum(id);
	}

	@Override
	public List<Album> getAllAlbum() {
		return albumDao.getAllAlbum();
	}

	@Override
	public int addAlbum(Album album) {
		return albumDao.addAlbum(album);
	}

	@Override
	public boolean delAlbum(int id) {
		return albumDao.delAlbum(id);
	}

	@Override
	public boolean updateAlbum(Album album) {
		return albumDao.updateAlbum(album);
	}
	@Override
	public Album getAlbumByName(String name) {
		return albumDao.getAlbumByName(name);
	}
}

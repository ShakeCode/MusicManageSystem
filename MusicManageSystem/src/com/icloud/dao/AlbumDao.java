package com.icloud.dao;

import java.util.List;

import com.icloud.entity.Album;

public interface AlbumDao {
	
	public Album getAlbum(int id);
	public Album getAlbumByName(String name);

	public List<Album> getAllAlbum();

	public int addAlbum(Album album);

	public boolean delAlbum(int id);

	public boolean updateAlbum(Album album);
}

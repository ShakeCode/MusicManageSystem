package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.icloud.dao.AlbumDao;
import com.icloud.entity.Album;
import com.icloud.entity.User;


public class AlbumDaoImpl implements AlbumDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Album getAlbum(int id) {
		String hql = "from t_album u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (Album)query.uniqueResult();
	}

	@Override
	public List<Album> getAllAlbum() {
		String hql = "from t_album";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Album> result = query.list();
		return result;
	}

	@Override
	public int addAlbum(Album album) {
		return (Integer) sessionFactory.getCurrentSession().save(album);
	}

	@Override
	public boolean delAlbum(int id) {
		String hql = "delete t_album u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateAlbum(Album album) {
		String hql = "update t_user u set u.name = ?,u.singer =?,u.views=?,u.introduction=? where u.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, album.getName());
		query.setString(1, album.getSinger());
		query.setInteger(2, album.getViews());
		query.setString(3, album.getIntroduction());
		query.setInteger(4, album.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	public Album getAlbumByName(String name) {
		String hql = "from t_album u where u.name=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		return (Album)query.uniqueResult();
	}
}

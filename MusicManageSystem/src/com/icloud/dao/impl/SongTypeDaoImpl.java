package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.icloud.dao.SongTypeDao;
import com.icloud.entity.SongType;

public class SongTypeDaoImpl implements SongTypeDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SongType getSongType(int id) {
		String hql = "from t_songtype u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (SongType)query.uniqueResult();
	}

	@Override
	public List<SongType> getAllSongType() {
		String hql = "from t_songType";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<SongType> result = query.list();
		return result;
	}

	@Override
	public int addSongType(SongType songtype) {
		return (Integer) sessionFactory.getCurrentSession().save(songtype);
	}

	@Override
	public boolean delSongType(int id) {
		String hql = "delete t_songtype u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}
}

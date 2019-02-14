package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.icloud.dao.SingerDao;
import com.icloud.entity.Singer;
import com.icloud.entity.User;

public class SingerDaoImpl implements SingerDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Singer getSinger(int id) {
		String hql = "from t_singer u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (Singer)query.uniqueResult();
	}

	@Override
	public Singer getSingerByName(String name) {
		String hql = "from t_singer u where u.name=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		return (Singer)query.uniqueResult();
	}

	@Override
	public List<Singer> getAllSinger() {
		String hql = "from t_singer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Singer> result = query.list();
		return result;
	}

	@Override
	public int addSinger(Singer singer) {
		return (Integer) sessionFactory.getCurrentSession().save(singer);
	}

	@Override
	public boolean delSinger(int id) {

		String hql = "delete t_singer u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateSinger(Singer singer) {
		String hql = "update t_user u set u.name = ? where u.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, singer.getName());
		query.setInteger(1, singer.getId());
		return (query.executeUpdate() > 0);
	}

}

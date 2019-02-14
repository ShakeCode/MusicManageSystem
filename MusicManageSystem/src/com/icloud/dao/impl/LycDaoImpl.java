package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.icloud.dao.LycDao;
import com.icloud.entity.Lyc;
import com.icloud.entity.User;

public class LycDaoImpl implements LycDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Lyc getLyc(int id) {
		String hql = "from t_lyc u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (Lyc)query.uniqueResult();
	}

	@Override
	public List<Lyc> getAllLyc() {
		String hql = "from t_lyc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Lyc> result = query.list();
		return result;
	}

	@Override
	public int addLyc(Lyc lyc) {
		return (Integer) sessionFactory.getCurrentSession().save(lyc);
	}

	@Override
	public boolean delLyc(int id) {
		String hql = "delete t_lyc u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateLyc(Lyc lyc) {
		String hql = "update t_lyc u set u.lycName = ?,u.songName=?,u.songID=?,u.lycURL=?,u.author=? where u.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, lyc.getLycName());
		query.setString(1, lyc.getSongName());
		query.setInteger(2, lyc.getSongID());
		query.setString(3, lyc.getLycURL());
		query.setString(4, lyc.getAuthor());
		query.setInteger(5, lyc.getId());
		return (query.executeUpdate() > 0);	}

}

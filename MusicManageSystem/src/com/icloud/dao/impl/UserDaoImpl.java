package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.icloud.dao.UserDao;
import com.icloud.entity.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUser(int id) {
		String hql = "from t_user u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (User)query.uniqueResult();
	}
	

	@Override
	public List<User> getAllUser() {
		String hql = "from t_user";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> result = query.list();
		return result;
	}

	@Override
	public int addUser(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean delUser(int id) {
		String hql = "delete t_user u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateUser(User user) {
		String hql = "update t_user u set u.name = ?,u.password=?,u.nickname=?,u.sex=?,u.qq=?,"
				+ "u.email=?,u.introduction=?  where u.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPassword());
		query.setString(2, user.getNickname());
		query.setString(3, user.getSex());
		if(user.getQq()==null || user.getQq().isEmpty()){		
			query.setString(4, " ");
		}else{
			query.setString(4, user.getQq());
		}
		if(user.getEmail()==null || user.getEmail().isEmpty()){;
			query.setString(5, " ");
		}else{
			query.setString(5, user.getEmail());
		}
		if(user.getIntroduction()==null || user.getIntroduction().isEmpty()){	
			query.setString(6, " ");
		}else{
			query.setString(6, user.getIntroduction());
		}
			query.setInteger(7, user.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	public User getUserByName(String name,String passward) {
		String hql = "from t_user u where u.name=? and u.password =?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, passward);
		return (User)query.uniqueResult();
	}

	@Override
	public User findUserByUserName(String username) {
		String hql = "from t_user u where u.name=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, username);
		return (User)query.uniqueResult();
	}

}

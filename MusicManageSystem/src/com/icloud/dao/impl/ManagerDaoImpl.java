package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.icloud.dao.ManagerDao;
import com.icloud.entity.Manager;

public class ManagerDaoImpl implements ManagerDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Manager getManager(int id) {
		String hql = "from t_manager u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		return (Manager)query.uniqueResult();
	}

	@Override
	public List<Manager> getAllManager() {
		String hql = "from t_manager";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Manager> result = query.list();
		return result;
	}

	@Override
	public int addManager(Manager manager) {
		return (Integer) sessionFactory.getCurrentSession().save(manager);
	}

	@Override
	public boolean delManager(int id) {
		String hql = "delete t_manager u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateManager(Manager manager) {
		String hql = "update t_manager u set u.name = ?,u.password=? where u.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, manager.getName());
		query.setString(1, manager.getPassword());
		query.setInteger(7, manager.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	public Manager getManagerByName(String name, String password) {
		String hql = " from t_manager u where u.name = ? and u.password = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, password);
		return (Manager)query.uniqueResult();
	}

}

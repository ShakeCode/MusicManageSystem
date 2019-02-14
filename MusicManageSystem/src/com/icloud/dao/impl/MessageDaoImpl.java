package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.icloud.dao.MessageDao;
import com.icloud.entity.Message;
import com.icloud.entity.User;

public class MessageDaoImpl implements MessageDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Message getMessage(int id) {
		String hql = "from t_message u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (Message)query.uniqueResult();
	}
	
	@Override
	public Message getMessageList(int offer) {
		String hql = "from t_message";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(20);
		return (Message)query.uniqueResult();
	}
	
	@Override
	public int getCount(){
		String hql = "select count(*) from t_message";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return Integer.parseInt(q.list().get(0).toString());
	}

	@Override
	public List<Message> getAllMessage() {
		String hql = "from t_message";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(20);
		List<Message> result = query.list();
		return result;
	}

	@Override
	public int addMessage(Message message) {
		return (Integer) sessionFactory.getCurrentSession().save(message);
	}

	@Override
	public boolean delMessage(int id) {
		String hql = "delete t_message u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateMessage(Message message) {
		String hql = "update t_message u set u.contant = ? where u.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, message.getContant());
		query.setInteger(1, message.getId());
		return (query.executeUpdate() > 0);
	}

	@Override
	public Message selectNowMessage() {
		String hql = "from t_message t where t.status ='1' ORDER BY t.createTime DESC LIMIT 1";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Message> result = query.list();
		return result.get(0);
		
	}

}

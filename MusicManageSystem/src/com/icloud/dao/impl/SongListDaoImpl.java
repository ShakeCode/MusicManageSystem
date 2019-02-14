package com.icloud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.icloud.dao.SongListDao;
import com.icloud.entity.Song;

public class SongListDaoImpl implements SongListDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//��ѯ���в����б�
	@Override
	public List<Song> selectSongListByUserName(String username) {
		String hql = " from t_song t where t.id in +'('+"
			+"SELECT songID from t_songlist a LEFT JOIN t_user u on a.userID = u.id" +
				"where a.name='播放列表' and u.name=?+')'+";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, username);
		List<Song> result = query.list();
		return result;
	}

}

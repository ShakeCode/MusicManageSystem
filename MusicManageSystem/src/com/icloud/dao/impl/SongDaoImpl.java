package com.icloud.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;

import com.icloud.dao.SongDao;
import com.icloud.entity.Pager;
import com.icloud.entity.Singer;
import com.icloud.entity.Song;
import com.icloud.entity.SongList;
import com.icloud.entity.User;

public class SongDaoImpl implements SongDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Song getSong(int id) {
		String hql = "from t_song u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (Song)query.uniqueResult();	
	}

	@Override
	public List<Song> getAllSong() {
		String hql = "from t_song";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Song> result = query.list();
		return result;
	}

	@Override
	public List<Song> getAllSongByType(String typeName) {
		String hql = "from t_song u where u.typeName = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, typeName);
		List<Song> result = query.list();
		return result;
	}

	@Override
	public int addSongr(Song song) {
		return (Integer) sessionFactory.getCurrentSession().save(song);
	}

	@Override
	public boolean delSongr(int id) {
		String hql = "delete t_song u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateSongr(Song song) {
		String hql = "update t_song s set s.songName = :songName, singer = :singer,"
				+ " album = :album, typeName = :typeName, hits = :hits, download = :download where id = :id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("songName", song.getSongName());
		query.setString("singer", song.getSinger());
		query.setString("album", song.getAlbum());
		query.setString("typeName", song.getTypeName());
		query.setInteger("hits", song.getHits());
		query.setInteger("download", song.getDownload());
		query.setInteger("id", song.getId());
		
		return (query.executeUpdate() > 0);
	}
	
	@Override
	public boolean updateSongHitOrDownLoad(Integer id,Integer hit, Integer download) {
		String sql ="";
		if(hit != null && download == null && id !=null){
		 sql = "UPDATE t_song t set  t.hits =(t.hits+1) where t.id=?";
		}else if(download !=null &&  hit == null && id !=null){
		sql = "UPDATE t_song t set  t.download =(t.download+1) where t.id=?";
		}
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		
		query.setInteger(0, id);
		
		return (query.executeUpdate() > 0);
	}

	//排行榜 ,sql模式，使用addEntity(xxx.class)映射对象，才有对应的属性值出现
	//hql模式，是自动有对象属性的
	@Override
	public List<Song> selectRankingListByType(String type){
		String hql = " select t.*,(t.hits+t.download) as rank from t_song t  where  t.typeName=? ORDER BY  (t.hits+t.download) DESC ";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(hql).addEntity(Song.class);;
		query.setString(0, type);
		List<Song> result = query.list();
		return result;
	}

		//hql模式，字段空，对应显示为空
		@Override
		public List<Song> selectSongListBySongName(String songName) {
			String hql = " from  t_song  t where t.songName like '%"+songName+"%'"+" or t.singer like '%"+songName+"%'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Song> result = query.list();
			return result;
		}
		//ģ����ѯ�����б�
		@Override
		public List<Singer> selectSingerListByName(String name){
			String hql = "from t_singer t WHERE t.name like '%"+name+"%'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Singer> result = query.list();
			return result;
		}

		@Override
		public Pager selectSongListByType(String type,Integer pageIndex,Integer pageSize) {
			String hql = "select t.* from t_song t WHERE t.typeName = ?";
			
			Pager pager = null;
			Query query =null;
			Session session = null;
			Transaction tx = null;
			Pager pageResult = null;
			try {
				 session=sessionFactory.openSession();
			    tx=session.beginTransaction();
			    
				pager = new Pager();
				pager.setHql(hql);
				pager.setPageSize(pageSize); 
				pager.setPageIndex(pageIndex);
				
			    query = session.createSQLQuery(hql).setCacheable(true);
			    query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			    query.setString(0, type);
			    pageResult = pagerTO(query,pager,session,tx);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return pageResult;
		}

		//sql模式
    	//查询播放列表,定制sql，使用createSQLQuery()，字段为空，不显示为"",分页查询
		@Override
		public Pager selectSongListByUserName(String username,Integer pageIndex,Integer pageSize){
			String hql = "select t.*,b.photoName from t_song t LEFT JOIN t_singer b on b.name = t.singer   where t.id in" +'('
					+" select songID from t_songlist a LEFT JOIN t_user u on a.userID = u.id" +
						" "+"where a.name='播放列表' and u.name=?"+')'+"";
			Pager pager = null;
			Query query =null;
			Session session = null;
			Transaction tx = null;
			Pager pageResult = null;
			try {
				 session=sessionFactory.openSession();
			    tx=session.beginTransaction();
			    
				pager = new Pager();
				pager.setHql(hql);
				pager.setPageSize(pageSize); 
				pager.setPageIndex(pageIndex);
				
			    query = session.createSQLQuery(hql).setCacheable(true);
			    query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			    query.setString(0, username);
			    pageResult = pagerTO(query,pager,session,tx);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return pageResult;
		}
		
		/**
		 * @param type
		 * @param pageIndex
		 * @param pageSize
		 * @return
		 */
		@Override
		public Pager selectSingerListByType(String type,Integer pageIndex,Integer pageSize) {
			Pager pager = null;
			Query query =null;
			Session session = null;
			Transaction tx = null;
			Pager pageResult = null;
			try {
				 session=sessionFactory.openSession();
			    tx=session.beginTransaction();
			    
				String hql = "from t_singer t WHERE 1=1 and t.type=:type ";
				pager = new Pager();
				pager.setHql(hql);
				pager.setPageSize(pageSize); 
				pager.setPageIndex(pageIndex);
				
			    query = session.createQuery(hql).setCacheable(true);
			    query.setString("type", type);
			    pageResult = pagerTO(query,pager,session,tx);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return pageResult;
		}

		//根据歌手名字搜索此歌手的歌曲列表  （分页！！！！！）
		@Override
		public Pager selectSongListBySinger(String singer,Integer pageIndex,Integer pageSize) {
			Pager pager = null;
			Query query =null;
			Session session = null;
			Transaction tx = null;
			Pager pageResult = null;
			try {
				 session=sessionFactory.openSession();
			    tx=session.beginTransaction();
			    
				String hql = "from t_song t where 1=1 and t.singer =:singer";
				pager = new Pager();
				pager.setHql(hql);
				pager.setPageSize(pageSize); 
				pager.setPageIndex(pageIndex);
				
			    query = session.createQuery(hql).setCacheable(true);
			    query.setString("singer", singer);
			    pageResult = pagerTO(query,pager,session,tx);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return pageResult;
		}
				
		@Override
		public Integer AddSongListByUserIdAndSongId(Integer userID, Integer songID) {
			SongList songList = new SongList();
			songList.setSongID(songID);
			songList.setUserID(userID);
			songList.setName("播放列表");
			return (Integer) sessionFactory.getCurrentSession().save(songList);
		}

		@Override
		public Boolean deleteSongList(Integer userID, Integer songID) {
			String hql = "delete from t_songlist  where userID = ? and songID= ? ";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setInteger(0, userID);
			query.setInteger(1, songID);
			return (query.executeUpdate() > 0);
		}

		@Override
		public Song selectSongById(Integer id){
			String hql = "from t_song u where u.id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setInteger(0, id);
			return (Song)query.uniqueResult();
		}

		//根据ID查询歌手信息
		@Override
		public List<Singer> selectSingerListById(Integer id) {
			String hql = "from t_singer t WHERE t.id= ? ";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setInteger(0, id);
			List<Singer> result = query.list();
			return result;
		}
		
		
		/**
		 * 分页存储
		 * @param p
		 * @param pram
		 * @return
		 */
		public Pager pagerTO(Query query,Pager p,Session session,Transaction tx) {
	        try {
	            //查询具体数据
	            int count=query.list().size();
	            p.setDataCount(count);
	            int nowPage=1;
	            if(p.getPageIndex()>0){
	                nowPage=p.getPageIndex();
	            }
	            p.setPageTotal((count-1)/p.getPageSize()+1);//这样就计算好了页码数量，逢1进1  
	            
	            //指定从那个对象开始查询，参数的索引位置是从0开始的，
	            query.setFirstResult((p.getPageIndex()-1)*p.getPageSize());
	            //分页时，一次最多产寻的对象数
	            query.setMaxResults(p.getPageSize());
//	            Object obj =  classz.getClass();
//	            List<Object> resultList = new ArrayList<Object>(); 
	            List<?> list1=query.list();   
	            
	            p.setList(list1);
	            tx.commit();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            tx.rollback();
	        }finally{
	            session.close();
	        }
	        return  p;
	    }

		@Override
		public List<Singer> selectSingerListByType(String type) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<SongList> selectSongListByIdAndUserId(Integer songId, Integer userId) {
			String hql = "from t_songlist t WHERE t.songID=? and t.userID= ? and name='播放列表' ";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setInteger(0, songId);
			query.setInteger(1, userId);
			List<SongList> result = query.list();
			return result;
		}
}

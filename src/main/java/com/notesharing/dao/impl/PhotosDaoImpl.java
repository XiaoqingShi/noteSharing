package com.notesharing.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notesharing.dao.PhotosDao;
import com.notesharing.model.Photos;

@Repository("photosDao")
public class PhotosDaoImpl implements PhotosDao {
	/**
	 * 使用@Autowired注解将sessionFactory注入到UserDaoImpl中
	 */

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable save(Photos photos) {
		// TODO Auto-generated method stub
		// return sessionFactory.getCurrentSession().save(photos);
		return sessionFactory.getCurrentSession().save(photos);
	}

	@Override
	public List<Photos> getPhotos() {
		List<Photos> photosList = new ArrayList<Photos>();
		String hql = "FROM  Photos";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		photosList = query.list();
		System.out.println(photosList.size());
		return photosList;
	}

	@Override
	public List<Photos> getPhotos(String tagName) {
		List<Photos> photosList = new ArrayList<Photos>();
		// String hql = "from Subject as s where s.subname like :name and s.subinfo like
		// :info";
		// // 调用session的获得数据列表方法，传递HQL查询语句
		// Query query = session.createQuery(hql);
		// query.setString("name","%"+name+"%");
		// query.setString("info","%"+info+"%");
		String hql = "FROM  Photos WHERE tag1 like:name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("name", "%" + tagName + "%");
		photosList = query.list();
		String hq2 = "FROM  Photos WHERE tag2 like:name";
		Query query2 = sessionFactory.getCurrentSession().createQuery(hq2);
		query2.setString("name", "%" + tagName + "%");
		photosList.addAll(query2.list());
		String hq3 = "FROM  Photos WHERE tag3 like:name";
		Query query3 = sessionFactory.getCurrentSession().createQuery(hq3);
		query3.setString("name", "%" + tagName + "%");
		photosList.addAll(query3.list());
		System.out.println(photosList.size());
		return photosList;
	}

	@Override
	public List<Photos> getUserPhotos(String userName) {
		List<Photos> photosList = new ArrayList<Photos>();
		String hql = "from Photos where author = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, userName);
		System.out.println("算了算了算了" + userName);
		photosList = query.list();
		return photosList;
	}

	@Override
	public int deletePhotos(Integer photosid) {
		Photos photos = new Photos();
		photos.setPhotosid(photosid);
		try {
			sessionFactory.getCurrentSession().delete(photos);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

}

package com.notesharing.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notesharing.dao.PhotoDao;
import com.notesharing.model.Photo;

@Repository("photoDao")
public class PhotoDaoImpl implements PhotoDao {
	/**
	 * 使用@Autowired注解将sessionFactory注入到UserDaoImpl中
	 */

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable save(Photo photo) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().save(photo);
	}

	@Override
	public int deletePhoto(Integer photosid) {
		String hql = "delete Photo where photoid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, photosid);
		query.executeUpdate();
		return 1;
	}

}

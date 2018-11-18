package com.notesharing.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notesharing.dao.PhotosCommentDao;
import com.notesharing.model.PhotosComment;

@Repository("photosCommentDao")
public class PhotosCommentDaoImpl implements PhotosCommentDao {
	/**
	 * 使用@Autowired注解将sessionFactory注入到UserDaoImpl中
	 */

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable saveComment(PhotosComment pComment) {
		return sessionFactory.getCurrentSession().save(pComment);
	}

	@Override
	public List<PhotosComment> getPhotosComment(int phontsId) {
		List<PhotosComment> usersList = new ArrayList<PhotosComment>();
		List comment = new ArrayList<>();
		String hql = "from PhotosComment where photosid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, phontsId);
		System.out.println("算了算了算了" + phontsId);
		usersList = query.list();

		return usersList;
	}

	@Override
	public int deletePhotosComment(Integer photosid) {
		String hql = "delete PhotosComment where photosid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, photosid);
		query.executeUpdate();
		return 1;
	}

}

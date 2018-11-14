package com.notesharing.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notesharing.dao.UserDaoI;
import com.notesharing.model.Users;

@Repository("userDao")
public class UserDaoImpl implements UserDaoI {

	/**
	 * 使用@Autowired注解将sessionFactory注入到UserDaoImpl中
	 */

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Users> getUsers() {
		List<Users> usersList = new ArrayList<Users>();
		String hql = "FROM  Users";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		usersList = query.list();
		System.out.println(usersList.size());
		return usersList;
	}

	@Override
	public Serializable getUser(Users userLogin) {
		// TODO Auto-generated method stub
		String hql = "from Users where u_name=? and u_password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(userLogin.getU_name());
		System.out.println(userLogin.getU_password());
		query.setParameter(0, userLogin.getU_name());
		query.setParameter(1, userLogin.getU_password());
		Users user2 = (Users) query.uniqueResult();
		return user2;
	}

	@Override
	public Serializable saveUser(Users user) {
		return sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean updateHeadportrait(String uname, String path) {
		// TODO Auto-generated method stub
		String hql = "update Users u set u.u_headportrait=:userName where u.u_name=:userId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userName", path);
		query.setParameter("userId", uname);
		query.executeUpdate();
		return true;
	}

	@Override
	public Serializable getUserRegister(String userName) {
		// TODO Auto-generated method stub
		String hql = "from Users where u_name = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, userName);

		Users user2 = (Users) query.uniqueResult();
		return user2;
	}

	@Override
	public String getHEADPORTRAIT(int uId) {
		String hql = "from Users where u_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, uId);

		Users user2 = (Users) query.uniqueResult();
		return user2.getU_headportrait();
	}

	@Override
	public Serializable getUserById(Integer uInteger) {
		// TODO Auto-generated method stub
		String hql = "from Users where u_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, uInteger);

		Users user2 = (Users) query.uniqueResult();
		return user2;
	}

}
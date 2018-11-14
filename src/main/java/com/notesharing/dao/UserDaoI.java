package com.notesharing.dao;

import java.io.Serializable;
import java.util.List;

import com.notesharing.model.Users;

public interface UserDaoI {

	/*
	 * 得到用户
	 */
	List<Users> getUsers();

	/*
	 * 用户登录
	 */
	Serializable getUser(Users userLogin);

	/*
	 * 查找用户
	 */
	Serializable getUserRegister(String userName);

	/*
	 * 查找用户
	 */
	Serializable getUserById(Integer uInteger);

	/**
	 * 保存用户
	 * 
	 * @param user
	 * @return
	 */
	Serializable saveUser(Users user);

	/*
	 * 上传头像更新用户信息表
	 */
	boolean updateHeadportrait(String uname, String path);

	/*
	 * 上传头像更新用户信息表
	 */
	String getHEADPORTRAIT(int uId);

}
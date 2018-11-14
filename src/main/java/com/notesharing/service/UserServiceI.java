package com.notesharing.service;

import java.io.Serializable;
import java.util.List;

import com.notesharing.model.Photo;
import com.notesharing.model.Photos;
import com.notesharing.model.PhotosComment;
import com.notesharing.model.Users;

public interface UserServiceI {

	/**
	 * 测试方法
	 */
	void test();

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

	/**
	 * 返回图片集
	 */
	List<Photos> getPhotos();

	/**
	 * 返回图片集
	 */
	List<Photos> getPhotos(String tagName);

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

	/**
	 * 保存图片的数据
	 */
	Serializable save(Photos photos);

	/**
	 * 保存单个图片的数据
	 */
	Serializable save(Photo photo);

	/**
	 * 返回图片集
	 */
	List getPhotosAndComment();

	/**
	 * 返回图片集
	 */
	List getPhotosFindAndComment(String tagName);

	/**
	 * 返回图片集
	 */
	List getPhotosUserName(String userName);

	/**
	 * 保存单个图片的数据
	 */
	Serializable saveComment(PhotosComment pComment);
}
package com.notesharing.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesharing.dao.PhotoDao;
import com.notesharing.dao.PhotosCommentDao;
import com.notesharing.dao.PhotosDao;
import com.notesharing.dao.UserDaoI;
import com.notesharing.model.Photo;
import com.notesharing.model.Photos;
import com.notesharing.model.PhotosComment;
import com.notesharing.model.Users;
import com.notesharing.service.UserServiceI;

//使用Spring提供的@Service注解将UserServiceImpl标注为一个Service  
@Service("userService")
public class UserServiceImpl implements UserServiceI {
	/**
	 * 注入userDao
	 */
	@Autowired
	private UserDaoI userDao;
	@Autowired
	private PhotosDao photosDao;
	@Autowired
	private PhotoDao photoDao;
	@Autowired
	private PhotosCommentDao photosCommentDao;

	@Override
	public void test() {
		System.out.println("Hello World!");
	}

	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public Serializable getUser(Users userLogin) {
		// TODO Auto-generated method stub
		return userDao.getUser(userLogin);
	}

	@Override
	public Serializable saveUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);
	}

	@Override
	public boolean updateHeadportrait(String uname, String path) {
		// TODO Auto-generated method stub
		return userDao.updateHeadportrait(uname, path);
	}

	@Override
	public Serializable save(Photos photos) {
		// TODO Auto-generated method stub
		return photosDao.save(photos);
	}

	@Override
	public Serializable save(Photo photo) {
		// TODO Auto-generated method stub
		return photoDao.save(photo);
	}

	@Override
	public Serializable getUserRegister(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserRegister(userName);
	}

	@Override
	public List<Photos> getPhotos() {
		// TODO Auto-generated method stub
		return photosDao.getPhotos();
	}

	@Override
	public List<Photos> getPhotos(String tagName) {
		// TODO Auto-generated method stub
		return photosDao.getPhotos(tagName);
	}

	@Override
	public List getPhotosAndComment() {
		List<Photos> photos = photosDao.getPhotos();

		List pList = new ArrayList<>();
		if (photos == null || photos.size() == 0)
			return null;
		for (int i = 0; i < photos.size(); i++) {
			Map<String, Object> pL = new HashMap<String, Object>();

			System.out.println("好事" + pL.size());
			List<PhotosComment> photosComments = photosCommentDao.getPhotosComment(photos.get(i).getPhotosid());
			pL.put("Photo", photos.get(i));
			System.out.println("对象 " + pL.get("Photo").toString());
			if (photosComments == null || photosComments.size() <= 0) {
				pL.put("Comment", null);
				pL.put("Comment_size", 0);
			} else {
				pL.put("Comment", photosComments);
				pL.put("Comment_size", photosComments.size());
			}
			pList.add(pL);
		}
		return pList;
	}

	@Override
	public List getPhotosFindAndComment(String tagName) {
		List<Photos> photos = photosDao.getPhotos(tagName);
		List pList = new ArrayList<>();
		if (photos == null || photos.size() == 0)
			return null;
		for (int i = 0; i < photos.size(); i++) {
			Map<String, Object> pL = new HashMap<String, Object>();

			System.out.println("好事" + pL.size());
			List<PhotosComment> photosComments = photosCommentDao.getPhotosComment(photos.get(i).getPhotosid());
			pL.put("Photo", photos.get(i));
			System.out.println("对象 " + pL.get("Photo").toString());
			if (photosComments == null || photosComments.size() <= 0) {
				pL.put("Comment", null);
				pL.put("Comment_size", 0);
			} else {
				pL.put("Comment", photosComments);
				pL.put("Comment_size", photosComments.size());
			}
			pList.add(pL);
		}
		return pList;
	}

	@Override
	public Serializable saveComment(PhotosComment pComment) {
		// TODO Auto-generated method stub
		return photosCommentDao.saveComment(pComment);
	}

	@Override
	public List getPhotosUserName(String userName) {
		List<Photos> photos = photosDao.getUserPhotos(userName);
		List pList = new ArrayList<>();
		if (photos == null || photos.size() == 0)
			return null;
		for (int i = 0; i < photos.size(); i++) {
			Map<String, Object> pL = new HashMap<String, Object>();

			System.out.println("好事" + pL.size());
			List<PhotosComment> photosComments = photosCommentDao.getPhotosComment(photos.get(i).getPhotosid());
			pL.put("Photo", photos.get(i));
			System.out.println("对象 " + pL.get("Photo").toString());
			if (photosComments == null || photosComments.size() <= 0) {
				pL.put("Comment", null);
				pL.put("Comment_size", 0);
			} else {
				pL.put("Comment", photosComments);
				pL.put("Comment_size", photosComments.size());
			}
			pList.add(pL);
		}
		return pList;
	}

	@Override
	public int deletePhotos(Integer photosid) {
		// TODO Auto-generated method stub
		try {
			photoDao.deletePhoto(photosid);
			photosCommentDao.deletePhotosComment(photosid);
			photosDao.deletePhotos(photosid);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
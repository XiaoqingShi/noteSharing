package com.notesharing.dao;

import java.io.Serializable;
import java.util.List;

import com.notesharing.model.PhotosComment;

public interface PhotosCommentDao {
	/**
	 * 保存用户
	 * 
	 * @param user
	 * @return
	 */
	Serializable saveComment(PhotosComment pComment);

	/*
	 * 得到用户
	 */
	List<PhotosComment> getPhotosComment(int phontsId);
}

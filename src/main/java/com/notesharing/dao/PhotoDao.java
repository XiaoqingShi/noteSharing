package com.notesharing.dao;

import java.io.Serializable;

import com.notesharing.model.Photo;

public interface PhotoDao {
	/**
	 * 保存单个图片
	 * 
	 * @param photos
	 * @return
	 */
	Serializable save(Photo photo);

	/**
	 * 删除图片
	 */
	int deletePhoto(Integer photosid);
}

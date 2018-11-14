package com.notesharing.dao;

import java.io.Serializable;
import java.util.List;

import com.notesharing.model.Photos;

public interface PhotosDao {
	/**
	 * 保存图片集 主id
	 * 
	 * @param <Photos>
	 * 
	 */
	Serializable save(Photos photos);

	/**
	 * 返回图片集
	 */
	List<Photos> getPhotos();

	/**
	 * 返回搜索图片集
	 */
	List<Photos> getPhotos(String tagName);

	/**
	 * 返回用户自己的图片集
	 */
	List<Photos> getUserPhotos(String userName);
}

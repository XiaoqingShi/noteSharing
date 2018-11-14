package com.notesharing.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.notesharing.model.Photos;
import com.notesharing.service.UserServiceI;
import com.notesharing.superAction.SuperAction;

@ParentPackage("jsonPackage")
@Action(value = "mainAction")
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
@Results({ @Result(name = "success", type = "json", params = { "root", "dataMap" }),
		@Result(name = "success_comment", type = "json", params = { "root", "dataMapAndComment" }),
		@Result(name = "successFind", type = "json", params = { "root", "dataMapAndFind" }) })
public class MainAction extends SuperAction {

	@Autowired
	private UserServiceI userService;
	private Map<String, Object> dataMap;
	private String main_info;// 信息

	private Map<String, Object> dataMapAndComment;
	private String main_infoAndComment;
	private String tagName;
	private Map<String, Object> dataMapAndFind;

	public String showData() {
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		List<Photos> photosList = userService.getPhotos();
		System.out.println("lslsls");
		main_info = "显示数据";
		dataMap.put("main_info", main_info);
		dataMap.put("Photos", photosList);
		return "success";
	}

	/**
	 * 返回搜索的数据
	 * 
	 * @return
	 */
	public String showFindData() {
		dataMapAndFind = new HashMap<String, Object>();
		dataMapAndFind.clear();
		List<Photos> photosList = userService.getPhotosFindAndComment(tagName);
		System.out.println("lslsls");
		main_info = "显示数据";
		dataMapAndFind.put("main_info", main_info);
		dataMapAndFind.put("Photos", photosList);
		return "successFind";
	}

	public String showDataAndComment() {
		dataMapAndComment = new HashMap<String, Object>();
		dataMapAndComment.clear();
		List aList = userService.getPhotosAndComment();
		System.out.println("lslsls" + aList.size());
		main_infoAndComment = "显示数据";
		dataMapAndComment.put("main_info", main_infoAndComment);
		dataMapAndComment.put("Photos", aList);

		return "success_comment";
	}

	public Map<String, Object> getDataMapAndFind() {
		return dataMapAndFind;
	}

	public void setDataMapAndFind(Map<String, Object> dataMapAndFind) {
		this.dataMapAndFind = dataMapAndFind;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getMain_info() {
		return main_info;
	}

	public void setMain_info(String main_info) {
		this.main_info = main_info;
	}

	public Map<String, Object> getDataMapAndComment() {
		return dataMapAndComment;
	}

	public void setDataMapAndComment(Map<String, Object> dataMapAndComment) {
		this.dataMapAndComment = dataMapAndComment;
	}

	public String getMain_infoAndComment() {
		return main_infoAndComment;
	}

	public void setMain_infoAndComment(String main_infoAndComment) {
		this.main_infoAndComment = main_infoAndComment;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}

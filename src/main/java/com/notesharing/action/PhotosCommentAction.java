package com.notesharing.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.notesharing.model.PhotosComment;
import com.notesharing.service.UserServiceI;
import com.notesharing.superAction.SuperAction;

@ParentPackage("jsonPackage")
@Action(value = "commentAction")
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
@Results({ @Result(name = "success", type = "json", params = { "root", "dataMap" }),

})
public class PhotosCommentAction extends SuperAction {

	@Autowired
	private UserServiceI userService;
	private int photosid;// 图片集id
	private String datatime;// 时间
	private String comment;// 内容
	private String u_name;// 用户名
	private String u_headportrait;// 头像地址
	private String saveComment_info;
	private Map<String, Object> dataMap;

	public String saveComment() {
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		PhotosComment pComment = new PhotosComment();
		pComment.setPhotosid(photosid);
		pComment.setDatatime(datatime);
		pComment.setComment(comment);
		pComment.setU_name(u_name);
		pComment.setU_headportrait(u_headportrait);
		if (userService.saveComment(pComment) != null)
			saveComment_info = "添加评论成功";
		else
			saveComment_info = "添加评论失败";
		dataMap.put("saveComment_info", saveComment_info);
		dataMap.put("status", "成功");
		return "success";
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getSaveComment_info() {
		return saveComment_info;
	}

	public void setSaveComment_info(String saveComment_info) {
		this.saveComment_info = saveComment_info;
	}

	public int getPhotosid() {
		return photosid;
	}

	public void setPhotosid(int photosid) {
		this.photosid = photosid;
	}

	public String getDatatime() {
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_headportrait() {
		return u_headportrait;
	}

	public void setU_headportrait(String u_headportrait) {
		this.u_headportrait = u_headportrait;
	}

}

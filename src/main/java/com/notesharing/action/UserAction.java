package com.notesharing.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.notesharing.model.Users;
import com.notesharing.service.UserServiceI;
import com.notesharing.superAction.SuperAction;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("jsonPackage")
@Action(value = "userregister")
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
@Results({ @Result(name = "success", type = "json", params = { "root", "dataMap" }),
		@Result(name = "deletePhotos", type = "json", params = { "root", "deletePhotos" }),
		@Result(name = "error", location = "/user/login_failure.jsp") })
public class UserAction extends SuperAction implements ModelDriven<Users> {
	private Users user = new Users();
	@Autowired
	private UserServiceI userService;
	private Map<String, Object> dataMap;
	private String register_info;
	private Map<String, Object> deletePhotos;

	/**
	 * 注册
	 * 
	 * @return
	 */
	public String register() {
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		Users u_old = (Users) userService.getUserRegister(user.getU_name());
		if (u_old != null) {
			register_info = "已存在账号";
			dataMap.put("login_info", register_info);
		} else {
			System.out.println("lslsls");
			user.setU_headportrait("/hi.jpg");
			userService.saveUser(user);
			register_info = "注册成功";
			dataMap.put("login_info", register_info);
			dataMap.put("Users", user);
		}
		return "success";
	}

	/**
	 * 用户删除图集
	 */
	public String deletePhotos() {
		deletePhotos = new HashMap<String, Object>();
		deletePhotos.clear();
		try {
			userService.deletePhotos(photosid);
			deletePhotos.put("delete_info", "成功");
		} catch (Exception e) {
			deletePhotos.put("delete_info", "失败");
			System.out.println("没有正确");
		}
		return "deletePhotos";
	}

	private Integer photosid;

	public Map<String, Object> getDeletePhotos() {
		return deletePhotos;
	}

	public void setDeletePhotos(Map<String, Object> deletePhotos) {
		this.deletePhotos = deletePhotos;
	}

	public Integer getPhotosid() {
		return photosid;
	}

	public void setPhotosid(Integer photosid) {
		this.photosid = photosid;
	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}

package com.notesharing.action;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.notesharing.service.UserServiceI;
import com.notesharing.superAction.SuperAction;
import com.opensymphony.xwork2.ActionContext;

@ParentPackage("jsonPackage")
@Action(value = "userUpload")
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
@Results({ @Result(name = "success", type = "json", params = { "root", "dataMap" }),
		@Result(name = "error", location = "/user/login_failure.jsp") })
public class UserUpload extends SuperAction {
	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String[] imageContentType; // 文件类型

	@Autowired
	private UserServiceI userService;
	private Map<String, Object> dataMap;
	private String userName;

	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		System.out.println(realpath);
		if (image != null) {
			File savedir = new File(realpath);
			if (!savedir.getParentFile().exists())
				savedir.getParentFile().mkdirs();
			Date date = new Date();
			String time = String.valueOf(date.getTime());// 按时间存图片
			int a = 0;
			String[] aStrings = imageFileName.split("\\.");
			// System.out.println(new Date().toString());
			File savefile = new File(savedir, time + "_" + aStrings[aStrings.length - 1]);
			String saveName = time + "_" + aStrings[aStrings.length - 1];
			FileUtils.copyFile(image, savefile);
			String path = "/user/images/" + saveName;
			System.out.println(path);
			userService.updateHeadportrait(userName, path);
		}
		ActionContext.getContext().put("message", "文件上传成功");
		dataMap.put("login_info", "上传成功");
		return "success";
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String[] getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String[] imageContentType) {
		this.imageContentType = imageContentType;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
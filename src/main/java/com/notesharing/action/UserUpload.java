package com.notesharing.action;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.notesharing.service.UserServiceI;
import com.notesharing.superAction.SuperAction;

public class UserUpload extends SuperAction {
	@Autowired
	private UserServiceI userService;
	private File myFile;

	private String myFileContentType;

	private String myFileFileName;

	private String destPath;
	List<String> userlist;

	public List<String> getUserlist() {
		return userlist;
	}

	public String execute() throws UnknownHostException {
		userlist = new ArrayList<String>();

		destPath = ServletActionContext.getServletContext().getRealPath("/images");
		InetAddress address = InetAddress.getLocalHost();// 获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
		String hostAddress = address.getHostAddress();// 192.168.0.121
		System.out.println(hostAddress);
		System.out.println(request.getScheme() + "://" + hostAddress + ":" + request.getServerPort()
				+ request.getContextPath() + "/images/" + myFileFileName);
		try {
			System.out.println("Src File name: " + myFile);
			System.out.println("Dst File name: " + myFileFileName);
			if (myFileFileName == null)
				myFileFileName = "1.jpg";
			File destFile = new File(destPath, myFileFileName);
			if (myFile == null)
				return ERROR;
			FileUtils.copyFile(myFile, destFile);
			userlist.add("上传成功");
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		String uname = (String) session.getAttribute("loginUserName");
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/images/" + myFileFileName;
		userService.updateHeadportrait(uname, path);
		userlist.add(path);
		return "success";
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
}
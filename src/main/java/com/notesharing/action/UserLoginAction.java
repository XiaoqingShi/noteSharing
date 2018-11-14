package com.notesharing.action;

import java.io.IOException;
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
@Action(value = "userlogin")
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
@Results({ @Result(name = "success", type = "json", params = { "root", "dataMap" }) })
public class UserLoginAction extends SuperAction implements ModelDriven<Users> {

	private Users user = new Users();
	@Autowired
	private UserServiceI userService;
	private Map<String, Object> dataMap;

	public UserLoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String login_info;

	/*
	 * 用户登录
	 */
	@SuppressWarnings("deprecation")
	public String login_test() throws IOException {
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		this.response.setContentType("text/json;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		System.out.println(user.getU_name());
		Users u = (Users) userService.getUser(user);
		if (u == null) {
			login_info = "登录失败";
			System.out.println("yyy登录失败");
			dataMap.put("login_info", login_info);

		} else {
			session.setAttribute("loginUserName", user.getU_name());
			System.out.println("登录成功");
			login_info = "登录成功";
			dataMap.put("login_info", login_info);
			dataMap.put("user", u);
		}
		return "success";
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

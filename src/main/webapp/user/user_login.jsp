<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <base href="<%=basePath%>">
	<form action="userlogin!login_test.action" method="post">
		<!--<form action="Users_login" method="post"> -->
		<h1>用户登陆页面</h1>
		<h4>装饰中......</h4>
		<hr />
		<table align="left">
			<tr>
				<td>账号：</td>
				<td><input type="text" name="u_name" id="name"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="u_password" id="password"></td>
			</tr>
			<tr>
				<td colspan="1"></td>
				<td><input type="submit" value="登陆" /> <input type="reset"
					value="重置" /> <a href="Users_register.jsp" target="_blank">注册</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
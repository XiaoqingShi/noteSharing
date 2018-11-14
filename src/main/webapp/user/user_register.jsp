<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<base href="<%=basePath%>">
	<form action="userregister!register.action" method="post" id="form1">
		<h1>用户注册页面</h1>
		<h4>装饰中......</h4>
		<hr />
		<table align="center">
			<tr>
				<td>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
				<td><input type="text" name="u_name" id="name" />
					<div id="nameError" style="display: inline; color: red;"></div></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td><input type="password" name="u_password" id="password">
					<div id="passwordError" style="display: inline; color: red;"></div></td>
			</tr>
			<!-- <tr>
				<td>确认密码：</td>
				<td><input type="password" name="u_password" id="relpassword">
					<div id="relpasswordError" style="display: inline; color: red;"></div></td>
			</tr> -->
			<tr>
				<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
				<td><input type="radio" name="u_gender" value="男" checked="checked" />男<input type="radio" name="u_gender" value="女" />女</td>
			</tr>
			<tr>
				<td>电话号码：</td>
				<td><input type="text" name="u_phone" id="phone"></td>
			</tr>
			<tr>
				<td colspan="1"></td>
				<td><input type="submit" value="注册" /> <input type="reset" value="重置" /> <a href="Users_login.jsp" target="_blank">登陆</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
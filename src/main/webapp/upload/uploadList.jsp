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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
	<!-- ${pageContext.request.contextPath}/upload/execute_upload.do -->
	<!-- ${pageContext.request.contextPath}/upload1/upload1.do -->
	<!-- ${pageContext.request.contextPath}/upload2/upload2.do -->
	<!--  -->
	<form action="userUploadList.action" method="post" enctype="multipart/form-data">
	作者<input type="text" name="author">
	<br/>
		标签1<input type="text" name="tag1"><br/>
		标签2<input type="text" name="tag2"><br/>
		标签3<input type="text" name="tag3"><br/>
		简介<input type="text" name="introduce"><br/>
		文件1:
		<input type="file" name="image">
		<br />
		文件2:
		<input type="file" name="image">
		<br />
		文件3:
		<input type="file" name="image">
		<br />
		<input type="submit" value="上传" />
	</form>
</body>
</html>
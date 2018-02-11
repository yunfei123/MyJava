<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/SendEmailServlet" method="post">
	<p>用户名:<input type="text" name="username"></p>
	<p>密    码:<input type="password" name="password"></p>
	<p>邮    箱:<input type="text" name="email"></p>
	<p><input type="submit" value="注册"></p>
</form>
</body>
</html>
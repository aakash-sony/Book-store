<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.nit.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
	CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	out.println("Page belongs to " + cb.getFullName() + "<br>");
	%>
	<a href="custView">AllBookDetails</a>
	<br>
	<a href="custLogout">Logout</a>
</body>
</html>
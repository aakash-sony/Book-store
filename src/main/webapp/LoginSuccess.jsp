<%@page import="com.nit.beans.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	AdminBean ab = (AdminBean)session.getAttribute("abean");
	
    out.println("<h2>Welcome Admin: "+ab.getfName()+"</h2><br>");
%>
<a href="addBook.html">AddBookDetails</a><br>
<a href="view">ViewAllBookDetails</a><br>
<a href="logout">Logout</a>
</body>
</html>
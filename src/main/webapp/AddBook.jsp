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
String message = (String)request.getAttribute("message");
out.println(message);
%>
<a href="addBook.html">AddBookDetails</a>
<a href="view">ViewAllBookDetails</a>
<a href="logout">Logout</a>
</body>
</html>
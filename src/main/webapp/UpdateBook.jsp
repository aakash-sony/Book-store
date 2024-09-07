<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.nit.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
//AdminBean ab = (AdminBean)session.getAttribute("abean");
String msg = (String)request.getAttribute("message");
out.println(msg);
%>
<%@include file= "ViewAllBook.jsp" %>
<!-- 
<a href="addBook.html">Add Book</a><br>
<a href="view">ViewAllBooks</a><br>
<a href="logout">Logout</a>
 -->
</body>
</html>
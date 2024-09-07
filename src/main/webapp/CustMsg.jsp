<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
String message = (String)request.getAttribute("message");
out.println(message);
%>
<%@include file = "CustomerLogin.html" %>
</body>
</html>
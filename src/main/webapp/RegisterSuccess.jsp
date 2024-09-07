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
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
String msg = (String)request.getAttribute("message");
out.println(msg);
%>
<%@include file = "CustomerLogin.html" %>
</body>
</html>
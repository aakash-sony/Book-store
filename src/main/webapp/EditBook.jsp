<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.nit.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//AdminBean ab = (AdminBean)session.getAttribute("abean");
BookBean bb = (BookBean)request.getAttribute("bbean");
out.println("Page Belongs to : "+bb.getBookName()+"<br>");
%>
<form action="update" method = "post">
<input type="hidden" name="bCode" value=<%=bb.getBookCode()%>>
Book Price:<input type="text" name="bPrice" value=<%=bb.getBookPrice()%>>
Book Quantity:<input type="text" name="bQty" value=<%=bb.getBookQty()%>>
<br>
<input type="submit" value="Update Book">
</form>
</body>
</html>
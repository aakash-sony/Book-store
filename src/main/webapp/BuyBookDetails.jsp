<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.nit.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	BookBean bb = (BookBean) session.getAttribute("selectedBook");
	if (bb != null) {
	%>
	<h2>
		Book Name:
		<%=bb.getBookName()%></h2>
	<h2>
		Book Author:
		<%=bb.getBookAuthor()%></h2>
	<h2>
		Book Price:
		<%=bb.getBookPrice()%></h2>
	<h2>
		Available Quantity:
		<%=bb.getBookQty()%></h2>
	<form action="buyProcess" method="post">
		<input type="hidden" name="bookCode" value="<%=bb.getBookCode()%>">
		Enter Quantity: <input type="number" name="buyQty" min="1"
			max="<%=bb.getBookQty()%>" required>
		<button type="submit">BuyBook</button>
	</form>
	<%
	} else {
	%>
	<p>Book not found.</p>
	<%
	}
	%>
</body>
</html>
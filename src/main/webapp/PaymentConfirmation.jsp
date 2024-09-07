<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
	Double totalPrice = (Double) session.getAttribute("totalPrice");
	String paymentMethod = (String) session.getAttribute("paymentMethod");

	if (paymentMethod != null && totalPrice != null) {
	%>
	<h1>Payment Successful</h1>
	<p>
		You have paid $<%=totalPrice%>
		via
		<%=paymentMethod%>.
	</p>

	<a href="custView">Go back to All Books</a><br>
	<a href="custLogout">Logout</a>
	<%
	} else {
	%>
	<p>Error confirming payment.</p>
	<%
	}
	%>
</body>
</html>
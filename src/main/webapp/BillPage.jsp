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
	Double totalPrice = (Double) session.getAttribute("totalPrice");
	Integer purchaseQty = (Integer) session.getAttribute("purchaseQty");
	BookBean bb = (BookBean) session.getAttribute("selectedBook");

	if (totalPrice != null && purchaseQty != null && bb != null) {
	%>
	<h1>Bill Details</h1>
	<p>
		Book Code:
		<%=bb.getBookCode()%></p>
	<p>
		Book Name:
		<%=bb.getBookName()%></p>
	<p>
		Selected Quantity:
		<%=purchaseQty%></p>
	<p>
		Total Price: $<%=totalPrice%></p>
	 <form action="choosePayment" method="post">
		<button type="submit">Proceed to Payment</button>
	</form>
	<%
	} else {
	%>
	<p>Error calculating bill.</p>
	<%
	}
	%>
</body>
</html>
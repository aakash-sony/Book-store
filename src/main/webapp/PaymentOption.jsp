<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>Select Payment Method</h1>
	<form action="confirmPayment" method="post">
		<input type="radio" id="phonepe" name="paymentMethod" value="PhonePe"
			required> <label for="phonepe">PhonePe</label><br> <input
			type="radio" id="gpay" name="paymentMethod" value="GPay"> <label
			for="gpay">GPay</label><br> <input type="radio" id="paytm"
			name="paymentMethod" value="Paytm"> <label for="paytm">Paytm</label><br>

		<button type="submit">Pay Now</button>
	</form>
</body>
</html>
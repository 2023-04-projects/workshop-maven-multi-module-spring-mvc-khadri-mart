<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Add Clothes</title>
</head>
<body>
	<h2>Add Clothes</h2>
<form action="${pageContext.request.contextPath}/clothes/adding" method="post">
		<label for="item_name"> Name:</label><br> <input type="text"
			id="item_name" name="itemName" required><br>
		<br> <label for="item_qty">Quantity:</label><br> <input
			type="number" id="item_qty" name="itemQty" required><br>
		<br> <label for="item_price">Price:</label><br> <input
			type="number" step="0.01" id="item_price" name="itemPrice" required><br>
		<br> <input type="submit" value="Add items">
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Vegetable</title>
</head>
<body>
	<table border="3">
		<h2>Add Vegetable</h2>
		<form action="${pageContext.request.contextPath}/veg/add"
			method="post">
			<label for="item_name"> Vegetable Name:</label><br>
			 <input type="text" name="itemName" required><br> <br> 
			 <label for="item_qty"> Vegetable Qty:</label><br> 
			 <input type="number" name="itemQty" required><br> <br> 
			 <label for="item_price">Vegetable Price:</label><br> 
			 <input type="number" step="0.01" name="itemPrice" required><br><br>
			 <input type="submit" value="Add Vegetable">
		</form>
	</table>
</body>
</html>
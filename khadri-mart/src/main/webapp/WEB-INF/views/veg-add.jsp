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
			<label for="veg_name"> Vegetable Name:</label><br>
			 <input type="text" name="vegName" required><br> <br> 
			 <label for="veg_qty"> Vegetable Qty:</label><br> 
			 <input type="number" name="vegQty" required><br> <br> 
			 <label for="veg_price">Vegetable Price:</label><br> 
			 <input type="number" step="0.01" name="vegPrice" required><br><br>
			 <input type="submit" value="Add Vegetable">
		</form>
	</table>
</body>
</html>
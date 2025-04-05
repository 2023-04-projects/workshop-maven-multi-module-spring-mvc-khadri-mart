<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Add Fruits</title>
</head>
<body>
	<table border="3">
		<h2>Add Fruits</h2>
		<form action="${pageContext.request.contextPath}/fruits/add"
			method="post">
			<label for="item_name"> Name:</label><br> <input type="text"
				name="itemName" required><br> <br> <label
				for="item_qty">Quantity:</label><br> <input type="number"
				name="itemQty" required><br> <br> <label
				for="item_price">Price:</label><br> <input type="number"
				step="0.01" name="itemPrice" required><br> <br> <input
				type="submit" value="Add items">
		</form>
	</table>
</body>
</html>

</body>
</html>
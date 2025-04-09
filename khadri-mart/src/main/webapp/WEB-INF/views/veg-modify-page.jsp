<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Modify Vegetables</title>
</head>
<body>
 <h2>Modify Vegetable Items</h2>
	    <form action="${pageContext.request.contextPath}/veg/modify" method="post">
		<table border="1">
				<tr>
					<td>Vegetable Name:</td>
					<td> <input type="text" name="vegName" value="${VegetableForm.vegName}" readonly></td>
				</tr>
				<tr>
					<td>Vegetable Qty:</td> 
					<td><input type="text" name="vegQty"  value="${VegetableForm.vegQty}"></td>
				</tr>
				<tr>
					<td>Vegetable Price:</td>
					<td> <input type="text" name="vegPrice" value="${VegetableForm.vegPrice}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Modify"></td>
				</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.khadri.spring.mvc.vegetable.controller.form.VegetableForm"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>View All Vegetable Page</title>
</head>
<body>
	<h2>View All Vegetable Items</h2>
	<table border="1">
		<tr>
			<th>Item</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
		<%
		List<VegetableForm> listOfVegetables = (List<VegetableForm>) request.getAttribute("listOfVegetables");
		if (listOfVegetables != null) {
			for (VegetableForm vegForm : listOfVegetables) {
		%>
		<tr>
			<td><%=vegForm.getVegName()%></td>
			<td><%=vegForm.getVegQty()%></td>
			<td><%=vegForm.getVegPrice()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="3">No vegetable items found.</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
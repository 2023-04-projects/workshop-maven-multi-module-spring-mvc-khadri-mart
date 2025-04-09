<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.khadri.spring.mvc.fruits.dao.FruitsDao"%>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>


<%
FruitsForm listOfFruits = (FruitsForm) request.getAttribute("fruitsForm");
String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Delete Fruits Items</title>
</head>
<body>
	<h2>Search Fruits Item</h2>
	<form action="search" method="post">
		<table>
			<tr>
				<td>Item Name: <input type="text" name="item_name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search Items"></td>
			</tr>
		</table>
	</form>
	<br>
	<%
	if (listOfFruits != null ) {

		
	%>
	<h3>Item Details</h3>
	<form method="post"
		action="${pageContext.request.contextPath}/fruits/delete">
		<table border="1">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="itemName"
					value="<%=listOfFruits.getItemName()%>" readonly></td>
			</tr>
			<tr>
				<td>Qty:</td>
				<td><input type="text" name="itemQty"
					value="<%=listOfFruits.getItemQty()%>" readonly></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="itemPrice"
					value="<%=listOfFruits.getItemPrice()%>" readonly></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form>
	<%
	}
	%>

	<%
	if (message != null) {
	%>
	<p style="color: green;"><%=message%></p>
	<%
	}
	%>
</body>
</html>
>

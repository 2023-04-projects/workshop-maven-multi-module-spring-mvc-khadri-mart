<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%
FruitsForm form = (FruitsForm) request.getAttribute("FruitsForm");
String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Search and Delete Fruits Items</title>
</head>
<body>
	<h2>Search Fruits Items</h2>
	<form action="search" method="post">
		<label for="name">Fruits Name:</label> <input type="text" id="name"
			name="fruitsName" required> <input type="submit"
			value="Search">
	</form>
	<%
	if (form != null) {
	%>
	<h3>Item Details</h3>
	<form action="${pageContext.request.contextPath}/fruits/delete"
		method="post">
		<table border="1">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="fruitsName"
					value="<%=form.getFruitsName()%>" readonly></td>
			</tr>
			<tr>
				<td>Qty:</td>
				<td><input type="text" name="fruitsQty"
					value="<%=form.getFruiytsQty()%>" readonly></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="fruitsPrice"
					value="<%=form.getFruitsPrice()%>" readonly></td>
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

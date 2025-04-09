<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page
	import="com.khadri.spring.mvc.grosary.controller.form.GrosaryForm"%>
<%
GrosaryForm form = (GrosaryForm) request.getAttribute("GrosaryForm");
String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Search and Delete Grocery Items</title>
</head>
<body>
	<h2>Search Grocery Items</h2>
	<form action="search" method="post">
		<label for="name">Grosary Name:</label> <input type="text" id="name"
			name="grosaryName" required> <input type="submit"
			value="Search">
	</form>
	<%
	if (form != null) {
	%>
	<h3>Item Details</h3>
	<form action="${pageContext.request.contextPath}/grosary/delete"
		method="post">
		<table border="1">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="grosaryName"
					value="<%=form.getGrosaryName()%>" readonly></td>
			</tr>
			<tr>
				<td>Qty:</td>
				<td><input type="text" name="grosaryQty"
					value="<%=form.getGrosaryQty()%>" readonly></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="grosaryPrice"
					value="<%=form.getGrosaryPrice()%>" readonly></td>
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

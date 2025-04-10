<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.khadri.spring.mvc.vegetable.controller.form.VegetableForm"%> 
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
	<%
		VegetableForm vegForm = (VegetableForm)request.getAttribute("VegetableForm");
	    String message = (String)request.getAttribute("message");
	%>
<html>
<head>
<title>Delete page</title>
</head>
<body>
<h2>Search Vegetable Item</h2>
	<form action="search" method="post">
	Vegetable Name: <input type="text" name="searchVegetables" /> <input
			type="submit" value="Search" />
	</form>
<%
	if (vegForm != null) {
	%>
	<h3>Vegetable Details</h3>
	<form method="post" action="${pageContext.request.contextPath}/veg/delete">
	<table border="1">
				<tr>
					<td>Vegetable Name:</td>
					<td><input type="text" name="vegName" value="<%=vegForm.getVegName()%>"
						readonly></td>
				</tr>
				<tr>
					<td>Vegetable Qty:</td>
					<td><input type="text" name="vegQty" value="<%=vegForm.getVegQty()%>" readonly>
					</td>
				</tr>
				<tr>
					<td>Vegetable Price:</td>
					<td><input type="text" name="vegPrice" value="<%=vegForm.getVegPrice()%>" readonly>
					</td>
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
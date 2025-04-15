<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Search and Delete Fruits Items</title>
<style>
.error {
	color: red;
	font-wight: bold;
	font-size: 13px;
}
</style>
</head>
<body>
	<h2>Search Fruits Items</h2>
	<form:form method="post" modelAttribute="searchForm"
		action="${pageContext.request.contextPath}/fruits/delete/search">
		<table>
			<tr>
				<td>FruitsName :</td>
				<td><form:input path="fruitsName" /></td>
				<td><form:errors path="fruitsName" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form:form>
	</br>
	<%
	FruitsForm form = (FruitsForm) request.getAttribute("FruitsForm");
	String message = (String) request.getAttribute("message");
	%>
	<%
	if (form != null) {
	%>
	<h3>Item Found</h3>
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
					value="<%=form.getFruitsQty()%>" readonly></td>
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
	<p class="message"><%=message%></p>
	<%
	}
	%>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.khadri.spring.mvc.fruits.dao.FruitsDao"%>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html>
<head>
<title>View Fruits Items</title>
<style>
.error {
	color: red;
	font-weight: bold;
	font-size: 13px;
}
</style>
</head>
<body>
	<h2>View Fruits</h2>
	<form:form method="post" modelAttribute="searchForm"
		action="${pageContext.request.contextPath}/fruits/view">
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
		<br>
		<%
		List<FruitsForm> listOfFruits = (List<FruitsForm>) request.getAttribute("searchListOfItem");
		String searchName = request.getParameter("searchFruits");
		if (listOfFruits != null && !listOfFruits.isEmpty()) {
		%>
		<table border="1">
			<thead>
				<tr>
					<th>Item</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (FruitsForm eachForm : listOfFruits) {
				%>
				<tr>
					<td><%=eachForm.getFruitsName()%></td>
					<td><%=eachForm.getFruitsQty()%></td>
					<td><%=eachForm.getFruitsPrice()%></td>
				</tr>
				<%
				}
				%>



			</tbody>
		</table>
		<%
		} else if (searchName != null) {
		%>
		<p>
			No item found for "<strong><%=searchName%></strong>".
		</p>
		<%
		}
		%>
	
</body>
</html>
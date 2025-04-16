<%@page import="com.khadri.spring.mvc.fruits.service.bo.FruitBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.khadri.spring.mvc.fruits.dao.FruitsDao"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>






<!DOCTYPE html>
<html>
<head>
<title>Modify Fruits Items</title>
<style>
.error {
	color: red;
	font-weight: bold;
	font-size: 13x
}
</style>
</head>
<body>
	<h2>Search Fruits Item</h2>
	<form:form method="post" modelAttribute="searchForm"
		action="${pageContext.request.contextPath}/fruits/search">

		<table>
			<tr>
				<td>Fruits Name: <form:input path="fruitsName" /></td>
				<td><form:errors path="fruitsName" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan='3'><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form:form>
	<br>
	<%
	List<FruitsForm> listOfSearchItemForms = (List<FruitsForm>) request.getAttribute("searchListOfItem");
	String searchName = request.getParameter("searchFruits");
	if (listOfSearchItemForms != null && !listOfSearchItemForms.isEmpty()) {
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
			for (FruitsForm eachForm : listOfSearchItemForms) {
			%>
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/fruits/modify?fruitsName=<%= eachForm.getFruitsName() %>&fruitsQty=<%= eachForm.getFruitsQty() %>&fruitsPrice=<%= eachForm.getFruitsPrice() %>">
						<%=eachForm.getFruitsName()%>
				</a></td>
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
		No items found for "<strong><%=searchName%></strong>".
	</p>
	<%
	}
	%>
</body>
</html>

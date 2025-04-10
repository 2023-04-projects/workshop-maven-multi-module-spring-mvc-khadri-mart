<%@page import="com.khadri.spring.mvc.fruits.service.bo.FruitBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.khadri.spring.mvc.fruits.dao.FruitsDao"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
String searchName = request.getParameter("searchFruits");
List<FruitsForm> listOfSearchItemForms = (List<FruitsForm>) request.getAttribute("searchListOfItem");
%>



<!DOCTYPE html>
<html>
<head>
<title>Modify Fruits Items</title>
<link rel='stylesheet' type='text/css' href='styles.css' />

</head>
<body>
	<h2>Search Fruits Item</h2>
	<form action="${pageContext.request.contextPath}/fruits/search/page" method="post">
		<table>
			<tr>
				<td>Fruits Name: <input type="text" name="searchFruits"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<br>
	<%
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
				<td> <a
					href="${pageContext.request.contextPath}/fruits/modify?fruitsName=<%= eachForm.getFruitsName() %>&fruitsQty=<%= eachForm.getFruiytsQty() %>&fruitsPrice=<%= eachForm.getFruitsPrice() %>"
					target="bottom-right"> <%=eachForm.getFruitsName()%>
				</a></td>
				<td><%=eachForm.getFruiytsQty()%></td>
				<td><%=eachForm.getFruitsPrice()%></td>
			</tr>
			<%
			}
			if (listOfSearchItemForms.isEmpty() && searchName != null) {
			%>
			<tr>
				<td colspan="3">No items found for "<%=searchName%>".
				</td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>

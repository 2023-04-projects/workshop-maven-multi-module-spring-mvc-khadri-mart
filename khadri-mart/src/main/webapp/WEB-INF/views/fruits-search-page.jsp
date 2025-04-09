<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.khadri.spring.mvc.fruits.dao.FruitsDao"%>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%
String searchName = request.getParameter("searchFruits");
List<FruitsForm> listOfFruits = (List<FruitsForm>) request.getAttribute("searchListOfItem");
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>Modify Fruits Items</title>
</head>
<body>
	<h2>Search Fruits Item</h2>
	<form action="${pageContext.request.contextPath}/fruits/search"
		method="post">
		<table>
			<tr>
				<td>Fruit Name: <input type="text" name="searchFruits"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<br>

	<% if (searchName != null && !searchName.isEmpty())  { %>
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
				<td><a
					href="${pageContext.request.contextPath}/fruits/modify?FruitName=<%=eachForm.getItemName()%>&Fruitqty=<%=eachForm.getItemQty()%>&Fruitprice=<%=eachForm.getItemPrice()%>"
					target="bottom_right"> <%=eachForm.getItemName()%>
				</a></td>
				<td><%=eachForm.getItemQty()%></td>
				<td><%=eachForm.getItemPrice()%></td>
			</tr>
			<% } 
				if (listOfFruits.isEmpty() && searchName != null) {
				%>
			<tr>
				<td colspan="3">No items found for "<%=searchName%>".
				</td>
			</tr>
			<% } 
			 } %>
		</tbody>
	</table>
	
</body>
</html>
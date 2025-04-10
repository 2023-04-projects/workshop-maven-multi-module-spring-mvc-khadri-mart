<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.khadri.spring.mvc.vegetable.controller.form.VegetableForm"%>
<%@ page import="java.util.*"%>
<%
List<VegetableForm> listOfVegetables = (List<VegetableForm>) request.getAttribute("listOfVegetables");
String searchName = request.getParameter("searchName");
%>
<body>
	<h1>View Vegetables</h1>
	<form action="${pageContext.request.contextPath}/veg/view" method="get">
		<label for="veg_name">Vegetable Name:</label> <input type="text"
			id="veg_name" name="vegName"
			value="<%=searchName != null ? searchName : ""%>"> <input
			type="submit" value="SearchItems">
	</form>
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
			if (listOfVegetables != null && !listOfVegetables.isEmpty()) {
				for (VegetableForm eachForm : listOfVegetables) {
			%>
			<tr>
				<td><%=eachForm.getVegName()%></td>
				<td><%=eachForm.getVegQty()%></td>
				<td><%=eachForm.getVegPrice()%></td>
			</tr>
			<%
			}
			} else if (searchName != null) {
			%>
			<tr>
				<td colspan="3">No items found for "<%=searchName%>".
				</td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
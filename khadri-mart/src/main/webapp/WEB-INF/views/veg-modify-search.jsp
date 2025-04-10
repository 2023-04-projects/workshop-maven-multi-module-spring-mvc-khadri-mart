<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.khadri.spring.mvc.vegetable.controller.form.VegetableForm"%> 
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>
<%@page import="com.khadri.spring.mvc.vegetable.service.bo.VegetableBO"%>
<%@page import="com.khadri.spring.mvc.vegetable.dao.VegetableDao" %>
<%@page import="java.util.*"%>

	<%
		String searchName = request.getParameter("searchVegetables");
	List<VegetableForm> listOfVegetables = (List<VegetableForm>) request.getAttribute("searchListOfVegetables");
		
	%>
<!DOCTYPE html>
<html>
<head>
<title>Modify Vegetable Items</title>
<link rel='stylesheet' type='text/css' href='styles.css' />

</head>
<body>
	<h2>Search Vegetable Item</h2>
	<form action="${pageContext.request.contextPath}/veg/search" method="post">
		<table>
			<tr>
				<td>Vegetable Name: <input type="text" name="searchVegetables"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<br>
	    <% if(listOfVegetables != null && !listOfVegetables.isEmpty()) { %>
	
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
				for (VegetableForm eachForm : listOfVegetables) {
			%>
			<tr>
				<td><a href="${pageContext.request.contextPath}/veg/modify?vegName=<%= eachForm.getVegName() %>&vegQty=<%= eachForm.getVegQty() %>&vegPrice=<%= eachForm.getVegPrice() %>" target="bottom-right"> 
                            <%= eachForm.getVegName() %> 
				</a></td>
				<td><%=eachForm.getVegQty()%></td>
				<td><%=eachForm.getVegPrice()%></td>
			</tr>
			<%
				}
			if (listOfVegetables.isEmpty() && searchName != null) {
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
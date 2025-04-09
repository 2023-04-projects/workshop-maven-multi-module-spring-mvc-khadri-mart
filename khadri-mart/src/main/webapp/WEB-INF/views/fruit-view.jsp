<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.khadri.spring.mvc.fruits.dao.FruitsDao"%>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%
    List<FruitsForm> listOfFruits = (List<FruitsForm>) request.getAttribute("listOfFruits");
    String searchName = (String) request.getAttribute("searchName");
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>View Fruits Items</title>
</head>
<body>
	<h2>View Fruits</h2>
	<form action="${pageContext.request.contextPath}/fruits/view"
		method="get">
		<label for="name">Fruit Name:</label> <input type="text"
			id="name" name="fruitname"> <input type="submit"
			value="Search">
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
            if (listOfFruits != null && !listOfFruits.isEmpty()) {
                for (FruitsForm eachForm : listOfFruits) {
        %>
			<tr>
				<td><%=eachForm.getItemName()%></td>
				<td><%=eachForm.getItemQty()%></td>
				<td><%=eachForm.getItemPrice()%></td>
			</tr>
			<%
                }
            } else if (searchName != null) {
        %>
        <tr>
            <td colspan="3">No items found for "<%= searchName %>".</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
</body>
</html>
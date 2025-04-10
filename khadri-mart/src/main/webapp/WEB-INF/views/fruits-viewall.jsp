<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%
List<FruitsForm> listOfFruits = (List<FruitsForm>) request.getAttribute("listOfGrosary");
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>View All Fruits Items</title>
</head>
<body>
	<h2>View All Fruits Items</h2>

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
			if (listOfFruits != null) {
				for (FruitsForm form : listOfFruits) {
			%>

			<tr>
				<td><%=form.getFruitsName()%></td>
				<td><%=form.getFruiytsQty()%></td>
				<td><%=form.getFruitsPrice()%></td>
			</tr>
			<%
			}
			} else {
			%>

			<tr>
				<td colspan="3">No fruits items found.</td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>
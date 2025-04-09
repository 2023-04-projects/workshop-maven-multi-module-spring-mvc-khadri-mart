<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.khadri.spring.mvc.fruits.dao.FruitsDao"%>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>
<%@ page
	import="com.khadri.spring.mvc.fruits.controller.form.FruitsForm"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%List<FruitsForm> listOfFruits = (List<FruitsForm>) request.getAttribute("listOfFruits"); %>

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
			<%
            
            if (listOfFruits != null) {
                for (FruitsForm eachForm : listOfFruits) {
        %>


			<tr>
				<td><%=eachForm.getItemName()%></td>
				<td><%=eachForm.getItemQty()%></td>
				<td><%=eachForm.getItemPrice()%></td>
			</tr>
			<%
			}
			}else{
			%>
			 <tr>
                <td colspan="3">No fruits found.</td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>

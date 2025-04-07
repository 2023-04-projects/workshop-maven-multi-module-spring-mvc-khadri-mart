<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.khadri.spring.mvc.grosary.controller.form.GrosaryForm"%>
<%
    List<GrosaryForm> listOfGrosary = (List<GrosaryForm>) request.getAttribute("listOfGrosary");
    String searchName = (String) request.getAttribute("searchName");
%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='styles.css' />
<title>View Grocery Items</title>
</head>
<body>
	<h2>View Grocery Items</h2>
	<form action="${pageContext.request.contextPath}/grosary/view"  method="get">
		<label for="name">Grocery Name:</label> <input type="text" id="name"
			name="grosaryName"> <input type="submit" value="Search">
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
            if (listOfGrosary != null && !listOfGrosary.isEmpty()) {
                for (GrosaryForm form : listOfGrosary) {
        %>
        <tr>
				<td><%=form.getGrosaryName()%></td>
				<td><%=form.getGrosaryQty()%></td>
				<td><%=form.getGrosaryPrice()%></td>
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
        %>		</tbody>
	</table>
</body>
</html>

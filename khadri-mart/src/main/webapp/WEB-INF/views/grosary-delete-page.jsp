.<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Delete Product</title>
</head>
<body>
	<%
		String name = request.getParameter("grosaryName");
		String qty = request.getParameter("grosaryQty");
		String price = request.getParameter("grosaryPrice");
	%>
	<form action="gro/delete" method="get">
		<table border="1">
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="grosaryName" value="<%=name%>"
						readonly></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td><input type="text" name="grosaryQty "value="<%=qty%>"
						readonly></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="text" name="grosaryPrice" value="<%=price%>"
						readonly></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="delete"></td>
				</tr>
			</table>
		</table>
	</form>
</body>
</html>

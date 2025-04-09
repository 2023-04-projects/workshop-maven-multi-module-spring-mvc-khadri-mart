<%@ page
	import="com.khadri.spring.mvc.clothes.controller.form.ClothesForm"%>
<%
ClothesForm form = (ClothesForm) request.getAttribute("clothesForm");
String message = (String) request.getAttribute("message");
%>
<html>
<head>
<title>Delete Clothes</title>
</head>
<body>
	<h2>Delete Clothes Item</h2>

	<form method="post" action="search">
		Search Name: <input type="text" name="searchClothes" /> <input
			type="submit" value="Search" />
	</form>

	<%
	if (form != null) {
	%>
	<h3>Item Details</h3>
	<form method="post"
		action="${pageContext.request.contextPath}/clothes/delete">
		<table border="1">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="itemName"
					value="<%=form.getItemName()%>" readonly></td>
			</tr>
			<tr>
				<td>Qty:</td>
				<td><input type="text" name="itemQty"
					value="<%=form.getItemQty()%>" readonly></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="itemPrice"
					value="<%=form.getItemPrice()%>" readonly></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form>
	<%
	}
	%>

	<%
	if (message != null) {
	%>
	<p style="color: green;"><%=message%></p>
	<%
	}
	%>
</body>
</html>

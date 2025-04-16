<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Add Fruits</title>
<style>
.error {
	color: red;
	font-weight: bold;
	font-size: 13px;
}
</style>
<link rel='stylesheet' type='text/css'
	href='${pageContext.request.contextPath}/styles.css' />
</head>
<body>

	<h2>Add Fruits Item</h2>

	<form:form modelAttribute="fruitsForm"
		action="${pageContext.request.contextPath}/fruits/add" method="post">
		<table>
			<tr>
				<td><label for="fruitsName">Fruits Name:</label></td>
				<td><form:input path="fruitsName" id="fruitsName" /> <form:errors
						path="fruitsName" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="fruitsQty">Quantity:</label></td>
				<td><form:input path="fruitsQty" id="fruitsQty" type="number" />
					<form:errors path="fruitsQty" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="fruitsPrice">Price:</label></td>
				<td><form:input path="fruitsPrice" id="fruitsPrice"
						type="number" /> <form:errors path="fruitsPrice" cssClass="error" />
				</td>
			</tr>


			<tr>
				<td></td>
				<td><input type="submit" value="Add Fruits" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>

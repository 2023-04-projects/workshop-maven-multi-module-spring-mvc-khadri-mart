<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Add Clothes</title>
<style>
    .error {
        color: red;
        font-weight: bold;
        font-size: 13px;
    }
</style>
</head>
<body>
	<h2>Add Clothes</h2>

	<c:if test="${not empty message}">
		<div style="color: green;">${message}</div>
	</c:if>

	<form:form method="post" modelAttribute="clothesForm"
		action="${pageContext.request.contextPath}/clothes/add">
		<table border="1">
			<tr>
				<td>Item Name:</td>
				<td><form:input path="itemName" /> <form:errors
						path="itemName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Item Qty:</td>
				<td><form:input path="itemQty" /> <form:errors path="itemQty"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Item Price:</td>
				<td><form:input path="itemPrice" /> <form:errors
						path="itemPrice" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Item" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>

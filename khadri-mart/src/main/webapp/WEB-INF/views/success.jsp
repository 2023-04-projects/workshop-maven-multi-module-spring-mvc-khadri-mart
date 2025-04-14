<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<body bgcolor="blue">
	<h1 style="color:white">Success Page</h1>
	<hr>
	<h2 style="color:yellow">
		<%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>
	</h2>
</body>
</html>

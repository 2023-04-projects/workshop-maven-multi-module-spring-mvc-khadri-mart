<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Grosary</title>
    <style>
    .error {
        color: red;
        font-weight: bold;
        font-size: 13px;
    }
</style>
    <link rel='stylesheet' type='text/css' href='styles.css' />
</head>
<body>
    <h2>Add Grosary Item</h2>
    <form:form modelAttribute="grosaryForm" 
               action="${pageContext.request.contextPath}/grosary/add" 
               method="post">
        <table>
            <tr>
                <td><label for="grosaryName">Grosary Name:</label></td>
                <td>
                    <form:input path="grosaryName" />
                    <form:errors path="grosaryName" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td><label for="grosaryQty">Quantity:</label></td>
                <td>
                    <form:input path="grosaryQty" type="number" />
                    <form:errors path="grosaryQty" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td><label for="grosaryPrice">Price:</label></td>
                <td>
                    <form:input path="grosaryPrice" type="number" />
                    <form:errors path="grosaryPrice" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add Grosary" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>

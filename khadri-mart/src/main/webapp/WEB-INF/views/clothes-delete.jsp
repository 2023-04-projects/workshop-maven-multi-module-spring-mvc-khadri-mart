<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.khadri.spring.mvc.clothes.controller.form.ClothesForm" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Clothes Items</title>
    <style>
        .error { color: red; }
        .message { color: green; }
    </style>
</head>
<body>

    <h2>Search Clothes Item to Delete</h2>

    <form:form method="post" modelAttribute="searchForm" action="${pageContext.request.contextPath}/clothes/delete/search">
        <table>
            <tr>
                <td>Item Name:</td>
                <td><form:input path="searchClothes" /></td>
                <td><form:errors path="searchClothes" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Search" /></td>
            </tr>
        </table>
    </form:form>

    <br/>

    <%
       ClothesForm form = (ClothesForm) request.getAttribute("ClothesForm");
        String message = (String) request.getAttribute("message");
    %>

    <% if (form != null) { %>
        <h3>Item Found</h3>
        <form action="${pageContext.request.contextPath}/clothes/delete" method="post">
            <table border="1">
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="ClothesName" value="<%= form.getItemName() %>" readonly /></td>
                </tr>
                <tr>
                    <td>Quantity:</td>
                    <td><input type="text" name="ClothesQty" value="<%= form.getItemQty() %>" readonly /></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="ClothesPrice" value="<%= form.getItemPrice() %>" readonly /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Delete" /></td>
                </tr>
            </table>
        </form>
    <% } %>

    <% if (message != null) { %>
        <p class="message"><%= message %></p>
    <% } %>

</body>
</html>

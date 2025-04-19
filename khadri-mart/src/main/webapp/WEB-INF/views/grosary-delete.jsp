<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.khadri.spring.mvc.grosary.controller.form.GrosaryForm" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Grocery Items</title>
    <style>
    .error {
        color: red;
        font-weight: bold;
        font-size: 13px;
    }
</style>
</head>
<body>

    <h2>Search Grocery Item to Delete</h2>

    <form:form method="post" modelAttribute="searchForm" action="${pageContext.request.contextPath}/grosary/delete/search">
        <table>
            <tr>
                <td>Grocery Name:</td>
                <td><form:input path="grosaryName" /></td>
                <td><form:errors path="grosaryName" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Search" /></td>
            </tr>
        </table>
    </form:form>

    <br/>

    <%
        GrosaryForm form =(GrosaryForm) request.getAttribute("GrosaryForm");
        String message = (String) request.getAttribute("message");
    %>

    <% if (form != null) { %>
        <h3>Item Found</h3>
        <form action="${pageContext.request.contextPath}/grosary/delete" method="post">
            <table border="1">
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="grosaryName" value="<%= form.getGrosaryName() %>" readonly /></td>
                </tr>
                <tr>
                    <td>Quantity:</td>
                    <td><input type="text" name="grosaryQty" value="<%= form.getGrosaryQty() %>" readonly /></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="grosaryPrice" value="<%= form.getGrosaryPrice() %>" readonly /></td>
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

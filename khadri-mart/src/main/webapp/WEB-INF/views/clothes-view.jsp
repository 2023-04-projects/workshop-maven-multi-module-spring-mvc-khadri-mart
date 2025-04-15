<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.khadri.spring.mvc.clothes.controller.form.ClothesForm" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Modify Clothes Items</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

    <h2>View Clothes Item</h2>

    <form:form method="post" modelAttribute="searchForm" action="${pageContext.request.contextPath}/clothes/view">
        <table>
            <tr>
                <td>Clothes Name:</td>
                <td><form:input path="searchClothes" /></td>
                <td><form:errors path="searchClothes" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Search" /></td>
            </tr>
        </table>
    </form:form>

    <br>

    <%
        List<ClothesForm> listOfSearchItemForms = (List<ClothesForm>) request.getAttribute("searchListOfItem");
        String searchName = request.getParameter("searchClothes");
        if (listOfSearchItemForms != null && !listOfSearchItemForms.isEmpty()) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>Item</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <% for (ClothesForm eachForm : listOfSearchItemForms) { %>
            <tr>
                <td>
                        <%= eachForm.getItemName() %>
                    
                </td>
                <td><%= eachForm.getItemQty() %></td>
                <td><%= eachForm.getItemPrice() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else if (searchName != null) { %>
    <% } %>

</body>
</html>

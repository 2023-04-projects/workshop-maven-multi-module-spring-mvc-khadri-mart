<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.khadri.spring.mvc.grosary.controller.form.GrosaryForm" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Modify Grosary Items</title>
    <style>
    .error {
        color: red;
        font-weight: bold;
        font-size: 13px;
    }
</style></head>
<body>

    <h2>Search Grosary Item</h2>

    <form:form method="post" modelAttribute="searchForm" action="${pageContext.request.contextPath}/grosary/search">
        <table>
            <tr>
                <td>Grosary Name:</td>
                <td><form:input path="grosaryName" /></td>
                <td><form:errors path="grosaryName" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Search" /></td>
            </tr>
        </table>
    </form:form>

    <br>

    <%
        List<GrosaryForm> listOfSearchItemForms = (List<GrosaryForm>) request.getAttribute("searchListOfItem");
        String searchName = request.getParameter("searchGrosary");
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
            <% for (GrosaryForm eachForm : listOfSearchItemForms) { %>
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/grosary/modify?grosaryName=<%= eachForm.getGrosaryName() %>&grosaryQty=<%= eachForm.getGrosaryQty() %>&grosaryPrice=<%= eachForm.getGrosaryPrice() %>">
                        <%= eachForm.getGrosaryName() %>
                    </a>
                </td>
                <td><%= eachForm.getGrosaryQty() %></td>
                <td><%= eachForm.getGrosaryPrice() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else if (searchName != null) { %>
        <p>No items found for "<strong><%= searchName %></strong>".</p>
    <% } %>

</body>
</html>

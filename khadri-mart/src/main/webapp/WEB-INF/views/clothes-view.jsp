<%@page import="java.util.*"%>
<%@ page import="com.khadri.spring.mvc.clothes.controller.form.ClothesForm" %>

<%
    List<ClothesForm> listOfClothes = (List<ClothesForm>) request.getAttribute("listOfClothes");
    String searchName = (String) request.getAttribute("searchName");
%>

<h2>View Clothes Items</h2>
<form action="${pageContext.request.contextPath}/clothes/view" method="get">
    <label for="clothesName">Item Name:</label>
    <input type="text" id="clothesName" name="clothesName" value="<%= searchName != null ? searchName : "" %>">
    <input type="submit" value="Search Items">
</form>

<table border="1">
    <thead>
        <tr>
            <th>Item</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <%
            if (listOfClothes != null && !listOfClothes.isEmpty()) {
                for (ClothesForm form : listOfClothes) {
        %>
        <tr>
            <td><%= form.getItemName() %></td>
            <td><%= form.getItemQty() %></td>
            <td><%= form.getItemPrice() %></td>
        </tr>
        <%
                }
            } else if (searchName != null) {
        %>
        <tr>
            <td colspan="3">No items found for "<%= searchName %>".</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

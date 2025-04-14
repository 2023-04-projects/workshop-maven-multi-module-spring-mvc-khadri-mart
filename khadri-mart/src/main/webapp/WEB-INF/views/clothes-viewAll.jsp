<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.khadri.spring.mvc.clothes.controller.form.ClothesForm" %>
<% List<ClothesForm> listOfClothes = (List<ClothesForm>) request.getAttribute("listOfClothes");%>
<html>
<head>
    <title>View All Clothes</title>
</head>
<body>
    <h2>All Clothes Items</h2>
    <table border="1">
        <tr>
            <th>Clothes Name</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>

        <%
            if (listOfClothes != null) {
                for (ClothesForm item : listOfClothes) {
        %>
                    <tr>
                        <td><%= item.getItemName() %></td>
                        <td><%= item.getItemQty() %></td>
                        <td><%= item.getItemPrice() %></td>
                    </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="3">No clothes found.</td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>

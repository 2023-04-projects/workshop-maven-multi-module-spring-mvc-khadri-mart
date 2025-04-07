<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="com.khadri.spring.mvc.grosary.controller.form.GrosaryForm" %>
<%
List<GrosaryForm> listOfGrosary = (List<GrosaryForm>) request.getAttribute("listOfGrosary");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' type='text/css' href='styles.css' />
    <title>View All Grosary Items</title>
</head>
<body>
    <h2>View All grosary Items</h2>

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
                
            if (listOfGrosary != null) {
                for (GrosaryForm item : listOfGrosary) {
            %>
            
             <tr>
                    <td><%= item.getGrosaryName() %></td>
                    <td><%= item.getGrosaryQty() %></td>
                    <td><%= item.getGrosaryPrice()%></td>
                </tr>
                 <%
                }
            } else {
        %>
             
            <tr>
                <td colspan="3">No grosary items found.</td>
            </tr>
            <%
                }
            %>
               
        </tbody>
    </table>
</body>
</html>
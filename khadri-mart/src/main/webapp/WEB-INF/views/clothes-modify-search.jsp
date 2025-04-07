<%@page import="com.khadri.spring.mvc.grosary.service.bo.GrosaryBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.khadri.spring.mvc.clothes.dao.ClothesDao" %>
<%@ page import="com.khadri.spring.mvc.clothes.controller.form.ClothesForm" %>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
    	
    <%
    String searchName = request.getParameter("searchClothes");
    List<ClothesForm> listOfSearchItemForms = (List<ClothesForm>) request.getAttribute("searchListOfItem");
    %>

        
   
<!DOCTYPE html>
<html>
<head>
    <title>Modify Clothes Items</title>
    <link rel='stylesheet' type='text/css' href='styles.css' />
    
</head>
<body>
    <h2>Search Clothes Item</h2>
<form action="${pageContext.request.contextPath}/clothes/search"
		method="post">      
		  <table>
            <tr>
                <td>Clothes Name: <input type="text" name="searchClothes"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>
    <br>
    <% if(listOfSearchItemForms != null && !listOfSearchItemForms.isEmpty()) { %>
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
            for (ClothesForm eachForm : listOfSearchItemForms){
            %>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/clothes/modify?clothesName=<%= eachForm.getItemName() %>&clothesQty=<%= eachForm.getItemQty() %>&clothesPrice=<%= eachForm.getItemPrice() %>" target="bottom-right">
                            <%= eachForm.getItemName() %>
                        </a>
                    </td>
                    <td><%= eachForm.getItemQty() %></td>
                    <td><%= eachForm.getItemPrice() %></td>
                </tr>
            <%
                }
			if (listOfSearchItemForms.isEmpty() && searchName != null) {

            %>
                <tr>
                    <td colspan="3">No items found for "<%= searchName %>".</td>
                </tr>
            <%
				}
			}
			%>
        </tbody>
    </table>
</body>
</html>

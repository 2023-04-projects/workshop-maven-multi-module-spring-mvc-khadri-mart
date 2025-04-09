<%@page import="com.khadri.spring.mvc.grosary.service.bo.GrosaryBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.khadri.spring.mvc.grosary.dao.GrosaryDao" %>
<%@ page import="com.khadri.spring.mvc.grosary.controller.form.GrosaryForm" %>
<%@page import="com.khadri.spring.mvc.dao.util.DaoUtil"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
    	
    <%
    String searchName = request.getParameter("searchGrosary");
    List<GrosaryForm> listOfSearchItemForms = (List<GrosaryForm>) request.getAttribute("searchListOfItem");
    %>

        
   
<!DOCTYPE html>
<html>
<head>
    <title>Modify Grosary Items</title>
    <link rel='stylesheet' type='text/css' href='styles.css' />
    
</head>
<body>
    <h2>Search Grosary Item</h2>
<form action="${pageContext.request.contextPath}/grosary/search"
		method="post">      
		  <table>
            <tr>
                <td>Grosary Name: <input type="text" name="searchGrosary"></td>
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
            for (GrosaryForm eachForm : listOfSearchItemForms){
            %>
                <tr>
                    <td>
</a>
                    
                        <a href="${pageContext.request.contextPath}/grosary/modify?grosaryName=<%= eachForm.getGrosaryName() %>&grosaryQty=<%= eachForm.getGrosaryQty() %>&grosaryPrice=<%= eachForm.getGrosaryPrice() %>" target="bottom-right">
                            <%= eachForm.getGrosaryName() %>
                        </a>
                    </td>
                    <td><%= eachForm.getGrosaryQty() %></td>
                    <td><%= eachForm.getGrosaryPrice() %></td>
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

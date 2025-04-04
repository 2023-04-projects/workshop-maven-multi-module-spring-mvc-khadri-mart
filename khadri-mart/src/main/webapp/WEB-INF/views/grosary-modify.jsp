<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.khadri.spring.mvc.dao.GrosaryDao" %>
<%@ page import="com.khadri.spring.mvc.form.GrosaryForm" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
    <%	
        String searchName = request.getParameter("grosaryName");
        List<GrosaryForm> listOfGrossaries = new ArrayList<>();
        if (searchName != null && !searchName.isEmpty()) {
        	ServletContext context = application;
            GrosaryDao dao = new GrosaryDao(context);
            listOfGrossaries = dao.selectGrosary(searchName);
        }
    %>
<!DOCTYPE html>
<html>
<head>
    <title>Modify Grosary Items</title>
    <link rel='stylesheet' type='text/css' href='styles.css' />
    
</head>
<body>
    <h2>Search Grosary Item</h2>
    
   <form action="grosary/modify" method="get">
        <table>
            <tr>
                <td>Grosary Name: <input type="text" name="grosaryName"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>
    <br>
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
                for (GrosaryForm eachForm : listOfGrossaries) {
            %>
                <tr>
                    <td>
                        <a href="grosary-modify-page.jsp?grosaryName=<%= eachForm.getGrosaryName() %>&grosaryQty=<%= eachForm.getGrosaryQty() %>&grosaryPrice=<%= eachForm.getGrosaryPrice() %>" target="bottom-right">
                            <%= eachForm.getGrosaryName() %>
                        </a>
                    </td>
                    <td><%= eachForm.getGrosaryQty() %></td>
                    <td><%= eachForm.getGrosaryPrice() %></td>
                </tr>
            <%
                }
			if (listOfGrossaries.isEmpty() && searchName != null) {

            %>
                <tr>
                    <td colspan="3">No items found for "<%= searchName %>".</td>
                </tr>
            <%
				}
			%>
        </tbody>
    </table>
</body>
</html>

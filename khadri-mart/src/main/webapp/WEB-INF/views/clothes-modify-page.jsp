<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modify Item</title>
</head>
<body>
    <h2>Modify Clothes Item</h2>

    <form action="${pageContext.request.contextPath}/clothes/modify" method="post">
        <table border="1">
            <tr>
                <td>Name:</td>
                <td><input type="text" name="itemName" value="${clothesForm.itemName}" readonly></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="itemQty" value="${clothesForm.itemQty}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="itemPrice" value="${clothesForm.itemPrice}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Modify"></td>
            </tr>
        </table>
    </form>
</body>
</html>

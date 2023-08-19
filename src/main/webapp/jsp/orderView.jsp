<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
	<jsp:include page="header.jsp" flush="true" />
		
	<jsp:include page="leftColumn.jsp" flush="true" />
	
<div class="center">
<h2> Thank you for your order!</h2>
</div>

<div class="center">
Your order is on the way to: <br>
<%= request.getParameter("address") %>, <br>
<%= request.getParameter("city") %>, <%= request.getParameter("province") %>, <br>
<%= request.getParameter("code") %> <br>
</div>

<div class="center">

Shipping speed: <%= request.getParameter("method") %> <br>
</div>

<div class="center">
<table border='1' cellpadding='6'>

<tr>
<th colspan='3' align=''>Items Ordered</th>
</tr> 

<tr>
<th>Image</th>
<th>Item</th>
<th>Quantity</th>
</tr>

<c:forEach items="${basket.getItems()}" var ="item">
	<tr>
	<td> <img src="${item.img}" /> </td>
	<td> ${item.name} </td>
	<td> ${item.qtyOrdered}</td>
</tr>

</c:forEach>

</table>
</div>

<div class="center">

<p><a href='groceries'>Continue Shopping...</a></p>
</div>
</div>

</body>
</html>
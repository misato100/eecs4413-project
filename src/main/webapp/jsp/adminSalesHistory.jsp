<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="css/grocerystore.css" type="text/css" />
<script src="js/grocerystore.js"></script>
</head>

<body>
	<div class="main">

		<jsp:include page="header.jsp" flush="true" />
		<jsp:include page="leftColumn.jsp" flush="true" />
		
		<div class="center">
			<table border='1' cellpadding='6'>

			<tr>
			<th colspan='4' align=''>Sales History</th>
			</tr>

			<tr>
			<th>Item</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Revenue</th>

			</tr>
			
			<c:forEach items="${applicationScope.history.getItems()}" var ="item">
			<tr> 
			<td>${item.name}</td> 
			<td>${item.qtyOrdered}</td>
			<td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.price}"/></td>
			<td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.price * item.qtyOrdered}"/></td>
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
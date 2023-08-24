<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basket</title>
<script src="grocerystore.js"></script>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="main">
		<jsp:include page="header.jsp" flush="true" />
		
		<jsp:include page="leftColumn.jsp" flush="true" />
<c:choose>
	<c:when test="${basket.isEmpty() == true}">
		<div class='center'><b style='color:red;'> Your cart is Empty </b>
		</div>
	</c:when>
	<c:otherwise>
	
<div class="center">
<table border='1' cellpadding='6'>

<tr>
<th colspan='5' align=''>Your Basket</th>
</tr>

<tr>
<th>Image</th>
<th>Item</th>
<th>Quantity</th>
<th>Price</th>
<th>Remove</th>

</tr>


<c:forEach items="${basket.getItems()}" var ="item">
	<tr>
	<td> <img src="${item.img}" /> </td>
	<td> ${item.name} </td>
	
	<td>
	<form method='get'>
		<input type='hidden' size='3' name='todo' value='update' />
		<input type='hidden' size='3' name='id' value='${item.id}' />
		<button type='button' onclick="minusOne(${item.id})">-</button>
		<input type='text' size='3' id='qty${item.id}' name='qty${item.id}' value='${item.qtyOrdered}' />
		<button type='button' onclick="addOne(${item.id})">+</button>
		<br><br>
		<input type='submit' value='Update' />
	</form>
	</td>
	
	<td> $${item.price} </td>
	
	<td>
	<form method='get'>
	<input type='hidden' size='3' name='todo' value='remove' >
	<input type='hidden' size='3' name='id' value='${item.id}'>
	<input type='submit' value='Remove'>
	</form>
	</td>
	</tr>
</c:forEach>

</table>
</div>

	
	</c:otherwise>
</c:choose>
<div class="center">
<p><a href='groceries'>Continue Shopping...</a></p>
</div>
</div>

<div class="center">
<table border='1' cellpadding ='6'>
	<tr><th align =''>Summary</th></tr>
	
	<tr><td> Subtotal: ${basket.total} <br>
			 Shipping: Calculated at checkout </td>
	</tr>
	
	<tr><td><form method='get' action='CheckoutServlet'>
	<input type='submit' value='Checkout Now'>
	<!-- Optional Guest Checkout? -->
	</form></td></tr>
</table>
</div>

</body>
</html>
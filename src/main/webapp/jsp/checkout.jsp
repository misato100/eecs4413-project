<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<script src="grocerystore.js"></script>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="main">
		<jsp:include page="header.jsp" flush="true" />
		
		<jsp:include page="leftColumn.jsp" flush="true" />

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

<tr><td colspan='6' align=''>Total Price: ${basket.total}
</td></tr>
</table>
</div>


<div class="center">
<p><a href='groceries'>Continue Shopping...</a></p>
</div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border='1' cellpadding='6'>
<tr>
<th>Grocery ID</th>
<th>Item</th>
<th>Price</th>
<th>QTY</th>
<th>REMOVE</th></tr>

<c:forEach items="${basket.getItems()}" var ="item">
	<tr>
	<td> ${item.id} </td>
	<td> ${item.name} </td>
	<td> ${item.price} </td>
	
	<td><form method='get'>
		<input type='hidden' size='3' name='todo' value='update' />
		<input type='hidden' size='3' name='id' value='${item.id}' />
		<input type='text' size='3' name='qty${item.id}' value='${item.qtyOrdered}' />
		<input type='submit' value='Update' />
	</form>
	</td>
	
	<td><form method='get'>
	<input type='hidden' size='3' name='todo' value='remove' >
	<input type='hidden' size='3' name='id' value='${item.id}'>
	<input type='submit' value='Remove'>
	</form>
	</td>
	</tr>
</c:forEach>

<tr><td colspan='5' align=''>Total Price: ${basket.total}
</td></tr>
</table>

<p><a href='groceries'>Continue Shopping...</a></p>

</body>
</html>
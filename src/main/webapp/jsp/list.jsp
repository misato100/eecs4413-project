<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
 	<form method='get' action='BasketServlet'>
	<div>
		<c:if test="${param.category != null}" > 
		<span class="label" style="margin-left: 15px;"> List of ${param.category} Groceries
		</span>
		</c:if>
	</div>

	<table id="grid">
		<thead>
			<tr>
				<th id="th-name">Name</th>
				<th id="th-country">Product of</th>
				<th id="th-category">Category</th>
				<th id="th-qty"> Qty </th>
				<th id="th-add"> Add to Cart</th>
			</tr>
		</thead>

		<tbody>

		<c:forEach items="${requestScope.groceryList}" var="item">
			<tr>
				<td id="grocery-name">${item.name}</td>
				<td>${item.country.name}</td>
				<td>${item.category}</td>
				<td><input type ='textbox' name = "qty${item.getId()}" value = '1' size = '5'></td>
				<td><input type='checkbox' name='id' value="${item.getId()}"/> <td>
			</tr>
		</c:forEach>
		</tbody>

	</table>
	<input type='hidden' name='todo' value='add' />
	<input type='submit' value='Add to my BASKET' />
	<input type='reset' value='CLEAR' />
	</form>
</body>
</html>
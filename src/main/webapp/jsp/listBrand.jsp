<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/grocerystore.js"></script>
</head>
<body>
<div class="content">
			<form action="groceries">		
			<select name="sort" class="trial" style="margin-left: 250px;" style="margin-right: 0;"  >
				<option disabled selected> Sort</option>
				<option value="ASC1" >Price: Lowest to Highest</option>
				<option value="DESC1">Price: Highest to Lowest</option>
				<option value="ASC2">Alphabetically: A-Z</option>
				<option value="DESC2">Alphabetically: Z-A</option>
			</select>
			<input type='hidden' name='keyWord' value="${param.keyWord}" />
			<input type='hidden' name='category' value="${param.category}" />
			<input type="hidden" name="action" value="${param.action}" />
			<input type="submit" value="Sort" class="trial"/>
			</form>
	</div>
<div class="center">
 	<form method='get' action='BasketServlet' class="form">
	<div>
		<c:if test="${param.brand != null}" > 
		<span class="label" style="margin-left: 15px;color: #212121"> List of ${param.brand}
		</span>
		</c:if>
	</div>
	<table id="grid">
		<thead>
			<tr>
				<th id="th-name">Name</th>
				<th id="th-country">Country</th>
				<th id="th-category">Brand</th>
				<th id="th-price">Price</th>
				<th id="th-qty"> Qty </th>
				<th id="th-add"> Add to Cart</th>
			</tr>
		</thead>

		<tbody>

		<c:forEach items="${requestScope.groceryList}" var="item">
			<tr>
				<td id="grocery-name">${item.name}</td>
				<td style="text-align:center;">${item.country.name}</td>
				<td style="text-align:center;">${item.brand}</td>
				<td style="text-align:center;">$${item.price}</td>
				<td><input type ='textbox' name = "qty${item.getId()}" value = '1' size = '5'/></td>
				<td><input type='checkbox' name='id' value="${item.getId()}"/> <td>
			</tr>
		</c:forEach>
		</tbody>

	</table>
	<input type='hidden' name='todo' value='add' />
	<input type='submit' value='Add to my BASKET' />
	<input type='reset' value='CLEAR' />
	</form>
</div>
</body>
</html>
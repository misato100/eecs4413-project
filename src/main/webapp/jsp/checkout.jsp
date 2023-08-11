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
<form>
<fieldset>
	<legend>1. Shipping Information</legend>
	<p>Address: 
		<input type="text" class="input" name="address">
	</p>
	<p>City: 
		<input type="text" class="input" name="city">
	</p>
	<p>Province: 
		<select name="province">
			<option selected="selected" value="ON">ON</option>
			<option value="QC">QC</option>
			<option value="NS">NS</option>
			<option value="NB">NB</option>
			<option value="MB">MB</option>
			<option value="BC">BC</option>
			<option value="PE">PE</option>
			<option value="SK">SK</option>
			<option value="AB">AB</option>
			<option value="NL">NL</option>
			<option value="NT">NT</option>
			<option value="YT">YT</option>
			<option value="NU">NU</option>
		</select>
	</p>
	<p>Postal Code: 
		<input type="text" class="input" name="code">
	</p>
</fieldset>

<fieldset>
	<legend>2. Shipping Method</legend>
	<input onclick="changeShipping(6.00, ${basket.total})" type="radio" name="method" value="regular"> Regular(4-5 days)      <b>$6.00</b> <br>
	<input onclick="changeShipping(10.00, ${basket.total})" type="radio" name="method" value="express"> Express(2-3 days)      <b>$10.00</b> <br>
	<c:choose>
		<c:when test="${basket.total > 100}">
			<input onclick="changeShipping(0.00, ${basket.total})" type="radio" name="method" value="free"> Free Express(For orders over $100)   <b>$0.00</b>
		</c:when>
		<c:otherwise> Add $${100- basket.total} to your basket to qualify for free shipping!
		</c:otherwise>
	</c:choose>
	
</fieldset>

<fieldset>
	<legend>3. Payment Method</legend>
	<p>Credit Card Number: 
		<input type="text" class="input" name="cc">
	</p>
	<p>Expiry Date: 
		<input type="text" class="input" name="expiry">
	</p>
	<p>Card Verification Number: 
		<input type="text" class="input" name="verification">
	</p>
</fieldset>
</form>
</div>

<form method="get" action="completeTransaction">
<div class="center">
<table border='1' cellpadding ='6'>
	<tr><th align =''>Summary</th></tr>
	
	<tr><td> Subtotal: ${basket.total} <br>
			 Shipping: <div id="shipping">---</div> <br>
			 Total: <div id="total">${basket.total}</div> </td>
	</tr>
	
	<tr><td>
	<input type='submit' value='Complete Purchase!'>
	<!-- Optional Guest Checkout? -->
</td></tr>
</table>
</div>
</form>

</body>
</html>
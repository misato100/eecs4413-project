<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="header">
	<h1>MKS GROCERY STORE</h1>
	<a href="${initParam.param2}?action=identification">SignIn/SignUp</a>
	<a href="${initParam.param2}?action=logout">Logout</a>
	<a href="${initParam.param3}">View Basket (${basket.totalSize()} items)</a>
</div>

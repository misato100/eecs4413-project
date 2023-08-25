<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/grocerystore.css" type="text/css" />
<script src="js/grocerystore.js"></script>
<div class="header">
	<h1 ><a href="${initParam.param1}" style="color: white;">MKS GROCERY STORE</a></h1>
	<c:choose>
		<c:when test="${loginName != null}">
			<a href="${initParam.param2}?action=seeProfile"> Welcome ${loginName}</a>
			<a href="${initParam.param2}?action=logout">Log Out</a>
		</c:when>
		<c:otherwise>
			<a href="${initParam.param2}?action=identification">Log In</a>
			<a href="${initParam.param2}?action=directToRegister">Register</a>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${basket != null && basket.totalSize() != 0}">
			<a href="${initParam.param3}">View Basket (${basket.totalSize()} items)</a>
		</c:when>
		<c:otherwise>
			<a href="${initParam.param3}">View Basket</a>
		</c:otherwise>
	</c:choose>

</div>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/grocerystore.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script src="js/grocerystore.js"></script>
</head>
<body>
	<div class="main">
		<jsp:include page="header.jsp" flush="true" />
		
		<jsp:include page="leftColumn.jsp" flush="true" />
		 
		<div class="center">
		<span class="title">Featured Groceries</span>

		<table class="images">
			<tr>
			<c:set var="row_num" value="1" />
			<c:forEach items="${allGroceries}" var="item">
				<td>
					<a href="${initParam.param1}?action=productDetails&keyWord=${item.name}"><span class="tooltip_img1"><img style="width: 1800%;height=1000%;" src="${item.img}" /></span>
					${item.name}</a>
				</td>
				<c:set var="row_num" value="${row_num + 1}" scope="page" />
				<c:if test="${row_num % 4 == 0}">
					</tr>
					<tr>
				</c:if>
					
				
        	</c:forEach>
        	</tr>
		</table>
		
		<!--  
		<table class="images">
			<tr>
				<td><a href="${initParam.param1}?action=productDetails">Cucumber<span class="tooltip_img1"><img src="${initParam.imageURL}/cucumber.png"/></span></a></td>
				<td>Green Onion<img src="${initParam.imageURL}/greenonion.png" /></td>
				<td>Lemon<img src="${initParam.imageURL}/lemon.png" /></td>
			</tr>
			<tr>
				<td>Watermelon<img src="${initParam.imageURL}/watermelon.png" /></td>
				<td>Ground Beef<img src="${initParam.imageURL}/leangroundbeef.png" /></td>
				<td>Chicken Breast<img src="${initParam.imageURL}/bonelesschickenbreast.png" /></td>
			</tr>
		</table>
		-->
		</div>
	</div>
</body>
</html>
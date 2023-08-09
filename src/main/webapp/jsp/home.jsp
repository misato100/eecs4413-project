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

		<!-- TODO: Change the images here? -->
		<table class="images">
			<tr>
				<td>Cucumber<span class="tooltip_img1"><img src="${initParam.imageURL}/cucumber.png"/></span></td>
				<td>Green Onion<img src="${initParam.imageURL}/greenonion.png" /></td>
				<td>Lemon<img src="${initParam.imageURL}/lemon.png" /></td>
				<!--  <td><img src="${initParam.imageURL}/A9781430231684-small_8.png" /></td>-->
				<!--  <td><img src="${initParam.imageURL}/A9781430249474-small_1.png" /></td>-->
			</tr>
			<tr>
				<td>Watermelon<img src="${initParam.imageURL}/watermelon.png" /></td>
				<td>Ground Beef<img src="${initParam.imageURL}/leangroundbeef.png" /></td>
				<td>Chicken Breast<img src="${initParam.imageURL}/bonelesschickenbreast.png" /></td>
				<!-- <td><img src="${initParam.imageURL}/A9781430246596-small_1.png" /></td>-->
				<!-- <td><img src="${initParam.imageURL}/A9781430257349-small_1.png" /></td>-->
			</tr>
		</table>
		</div>
	</div>
</body>
</html>
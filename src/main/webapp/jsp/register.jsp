<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/grocerystore.css" type="text/css" />
<script src="js/grocerystore.js"></script>
</head>

<body>
	<div class="main">

		<jsp:include page="header.jsp" flush="true" />
		<jsp:include page="leftColumn.jsp" flush="true" />

		<div class="user_input">
		<c:set var="validated" value="${requestScope.validation}" />
		<c:set var="validateWith" value="false" />
		
		<div class="ui_item">
		<c:choose>
			<c:when test="${validated != validateWith}"><p style="font-weight: bold;">Register Here</p></c:when>
        	<c:otherwise>The Username or Email exists</c:otherwise>
		</c:choose>
		</div>
		
		<form action="UserManager" method="POST">
			<div class="ui_item">
			Username:  <input type="hidden" name="action" value="register" />
			<input id="text" type="text" name="username" size="20" /> <span class="tooltip_message">?</span>
			</div>
			<div class="ui_item">
			First Name:  
			<input id="text" type="text" name="firstname" size="20" /> <span class="tooltip_message">?</span>
			</div>
			<div class="ui_item">
			Last Name:  
			<input id="text" type="text" name="lastname" size="20" /> <span class="tooltip_message">?</span>
			</div>
			<div class="ui_item">
			Email: 
			<input id="text" type="text" name="email" size="20" /> <span class="tooltip_message">?</span>
			</div>
			<div class="ui_item">
			Password: 
			<input id="text" type="password" name="password" size="12" /> <span class="tooltip_message">?</span>
			</div>
			<div class="ui_item">
			<input id="submit" type="submit" value="Register" />
			</div>
		</form>
		</div>
		
	</div>
	
</body>
</html>
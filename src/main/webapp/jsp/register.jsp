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
	<div id="centered">

		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumn.jsp" flush="true" />

		<c:set var="validated" value="${requestScope.validation}" />
		<c:set var="validateWith" value="false" />
		
		<c:choose>
			<c:when test="${validated != validateWith}"><p>Register Here</p></c:when>
        	<c:otherwise>The Username or Email exists</c:otherwise>
		</c:choose>
		
		<form action="UserManager" method="POST">
			Username:  <input type="hidden" name="action" value="register" />
			<input id="text" type="text" name="username" size="12" /> <span class="tooltip_message">?</span>
			<br />
			First Name:  
			<input id="text" type="text" name="firstname" size="12" /> <span class="tooltip_message">?</span>
			<br />
			Last Name:  
			<input id="text" type="text" name="lastname" size="12" /> <span class="tooltip_message">?</span>
			<br />
			Email: 
			<input id="text" type="text" name="email" size="12" /> <span class="tooltip_message">?</span>
			<br />
			Password: 
			<input id="text" type="text" name="password" size="12" /> <span class="tooltip_message">?</span>
			<br />
			<input id="submit" type="submit" value="Register" />
		</form>

	</div>
	
</body>
</html>
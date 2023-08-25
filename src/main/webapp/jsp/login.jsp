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
			<div class="ui_item"><span style="font-weight: bold;">Sign In Here</span></div>
			<c:set var="msg" value="${notValidated}" /> <!-- Modify here? -->
			<c:out value="${msg}" />
		
		<form action="UserManager" method="POST">
			<div class="ui">
			Username or Email:  <input type="hidden" name="action" value="login" />
			<input id="text" type="text" name="username" size="20" /> <span class="tooltip_message">?</span>
			</div>
			<div class="ui">
			Password:  <input type="hidden" name="action" value="login" />
			<input id="text" type="password" name="password" size="12" /> <span class="tooltip_message">?</span>
			</div>
		<div class="ui"><input id="submit" type="submit" value="Sign In" /></div>
		</form>
		
			<p style="font-weight: bold;">Or register here: 
			<a href="${initParam.param2}?action=directToRegister"><span>Register</span></a></p>
		</div>
	</div>
	
</body>
</html>
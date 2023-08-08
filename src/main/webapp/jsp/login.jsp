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
		
		<div>
			<span class="label" style="margin-left: 15px;">Sign In Here</span>
		</div>
		
		<form action="UserManager" method="POST">
			Username or Email:  <input type="hidden" name="action" value="login" />
			<input id="text" type="text" name="username" size="12" /> <span class="tooltip_message">?</span>
			Password:  <input type="hidden" name="action" value="login" />
			<input id="text" type="password" name="password" size="12" /> <span class="tooltip_message">?</span>
		<p />
		<input id="submit" type="submit" value="Sign In" />
		</form>
		
		<br />
		<p>Or register here: </p>	 
		<a class="link" href="${initParam.param2}?action=directToRegister"><span>Register</span>
		
	</div>
	
</body>
</html>
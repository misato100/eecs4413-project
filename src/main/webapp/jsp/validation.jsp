<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<div id="centered">

		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumn.jsp" flush="true" />
		
		<div>
			<span class="label" style="margin-left: 15px;"><c:out value="${param.options}"/></span>
		</div>
		<br />
		
		<!-- 
			If userid == 0, password is incorrect
			If userid < 0, user is not found
			If userid > 0, user is found and password is correct
		 -->
        <c:set var="userid" value="${requestScope.foundUser.id}" />
        <c:set var="compid" value="0" />

		<!--
			TODO: Create a link to go back to the login page
		 	when password is incorrect or user is not found
		 -->
		<c:choose>
			<c:when test="${userid == compid}"><p>Incorrect password</p></c:when>
        	<c:when test="${userid > compid}">Login Success</c:when>
        	<c:otherwise>User not Found</c:otherwise>
		</c:choose>

	</div>

</body>
</html>
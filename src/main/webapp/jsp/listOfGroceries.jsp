<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<link rel="stylesheet" href="css/grocerystore.css" type="text/css" />
<script src="js/grocerystore.js" type="text/javascript"></script>
</head>

<body>
	<div class="main">
		<jsp:include page="header.jsp" flush="true" />

		<jsp:include page="leftColumn.jsp" flush="true" />
		<div class="center">
			<span>List of All Groceries</span>
			<jsp:include page="list.jsp" flush="true" />
		</div>
	</div>
</body>
</html>


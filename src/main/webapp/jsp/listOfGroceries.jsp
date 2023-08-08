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
	<div id="centered">

		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumn.jsp" flush="true" />
		<div>
			
			<form action="groceries">
			<span class="label" style="margin-left: 15px;">List of All Groceries</span>
			
			<select name="sort" class="trial" style="margin-left: 250px;" style="margin-right: 0;"  >
				<option disabled selected> Sort</option>
				<option value="ASC1" >Price: Lowest to Highest</option>
				<option value="DESC1">Price: Highest to Lowest</option>
				<option value="ASC2">Alphabetically: Z-A</option>
				<option value="DESC2">Alphabetically: A-Z</option>
			</select>
			<input type="hidden" name="action" value="allGroceries" />
			<input type="submit" value="Sort" class="trial"/>
			</form>
		</div>
		<jsp:include page="list.jsp" flush="true" />

	</div>
</body>
</html>


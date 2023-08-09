<%@page language="java" contentType="text/html"%>

<%-- <%@page import="java.util.Enumeration"%> --%>
<%-- <%@page import="java.util.Hashtable"%> --%>
<%-- <%@page import="java.util.List"%> --%>
<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <%@page import="java.util.Iterator"%> --%>
<%-- <%@page import="model.Book"%> --%>
<%-- <%@page import="model.Category"%> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/grocerystore.css" type="text/css" />
<script src="js/grocerystore.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
</head>
<body>
<div class="left_column">
	<ul>
		<li><a href="${initParam.param1}"><span>Home</span></a></li>
			
		<li><a href="${initParam.param1}?action=allGroceries"><span>All Groceries</span></a></li>
			
		<li><span class="tab_title">Categories</span>
			<ul style="padding: 5px;">
			  <c:forEach items="${categoryList}" var="item"> 		     
				<li style="background-color: #3d3d3d; margin: 5px 10px; padding: 5px;">
				<a class="tab" href="${initParam.param1}?action=category&categoryId=${item.id}&category=${item.categoryDescription}">
				<span>${item.categoryDescription}</span></a>
				</li>
              </c:forEach>			
			</ul></li>
	</ul>
	
	<form class="search">
		<span>Search: </span><input type="hidden" name="action" value="search" /> <input id="text"
			type="text" name="keyWord" size="12" /> <span
			class="tooltip_message">?</span>
		<input id="submit" type="submit" value="Search" />
	</form>

</div>
</body>





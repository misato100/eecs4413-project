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
			
		<li><span class="tab_title">Brands</span>
			<ul style="padding: 5px;">
			  <c:forEach items="${brandList}" var="item">
				<li style="background-color: #3d3d3d; margin: 5px 10px; padding: 5px;">
				<a class="tab" href="${initParam.param1}?action=brand&brandId=${item.id}&brand=${item.name}">
				<span>${item.name}</span></a>
				</li>
              </c:forEach>			
			</ul></li>
	</ul>
	
	<p style="color: white;">Search By Name Below</p>
	<form class="search">
		<span>Search: </span><input type="hidden" name="action" value="search" /> <input id="text"
			type="text" name="keyWord" size="12" />
		<input id="submit" type="submit" value="Search" />
	</form>
	
	<c:choose>
		<c:when test="${adminLoginName != null}">
		<p style="font-weight: bold;"><a href="${initParam.param2}?action=adminLogin&status=loggedin">Sales History</a></c:when>
        <c:otherwise></c:otherwise>
	</c:choose>
	
	<h2 style="color: #ffffff;">Welcome ${loginName}</h2>

</div>
</body>
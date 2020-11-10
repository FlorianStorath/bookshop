<%@page import="bookshop.entity.Book"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
<ul>
		<c:forEach items="${books}" var="b">
			<li><c:out value="${b.title}, ${b.author}, ${b.year}"/></li>
		</c:forEach>
	</ul>
</body>
</html>
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
<h1><c:out value="${empty pageTitle ? 'Anzeige von Büchern' : pageTitle}"/></h1>
	<form action="merken" method="post">
		<c:forEach items="${books}" var="b">
			<li>
			<c:if test="${!merkenFormDisabled}">
					<input type="checkbox" name="id" value="${f.id}">
				</c:if>
			<c:out value="${b.title}, ${b.author}, ${b.year}"/></li>
		</c:forEach>
	</ul>
	<c:if test="${!merkenFormDisabled}">
		<input type="submit" value="Markierte Bücher in Warenkorb ablegen">
	</c:if>
</body>
</html>
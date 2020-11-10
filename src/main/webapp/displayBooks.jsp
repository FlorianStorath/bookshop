<%@page import="bookshop.entity.Book"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
<ul>
<% Collection<Book> books = (Collection<Book>) request.getAttribute("Books"); 
	for(Book b : books) {
		%><li><%=b.getTitle() %> , <%=b.getAuthor() %> , <%=b.getYear() %></li><%	
	}
 %>
</ul>
</body>
</html>
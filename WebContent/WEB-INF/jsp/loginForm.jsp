<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<% User error = (User)session.getAttribute("error"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Git-tutorial</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="/Git-tutorial/LoginServlet" method="post">
		<input type="text" name="id">
		<input type="password" name="password">
		<input type="submit">
	</form>
	<% if (error != null) { %>
		<h2><%= error.getErrorMsg() %></h2>
	<% } %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<% User admin = (User)session.getAttribute("admin"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Git-tutorial</title>
</head>
<body>
<h1>LOGIN SUCCESS!</h1>
<h2>Welcome <%= admin.getId() %></h2>
<a href="/Git-tutorial/AdministoratorServlet">show databases</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Índice</title>
</head>
<body>

<% for(int i = 1; i <= 6; i++) { %>
<h1>Prueba <%= LocalDate.now() %> </h1>
<% } %>

</body>
</html>

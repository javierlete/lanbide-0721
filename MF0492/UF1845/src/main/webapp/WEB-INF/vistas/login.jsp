<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- import="com.ipartek.formacion.uf1845.modelo.*" --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="login" method="post">
	<input type="email" name="email" placeholder="Email" 
		value="${usuario.email}">
	<%-- value="<%= ((Usuario)request.getAttribute("usuario")).getEmail() %>"> --%>
	<input type="password" name="password">
	
	<button>Login</button>
	<%-- <span><%= request.getAttribute("mensaje") %></span> --%>
	<span>${mensaje}</span>
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ipartek.formacion.uf1845.modelos.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Principal</title>
</head>
<body>
	<h1>Principal</h1>

	<h2>${usuario.email}</h2>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Autor</th>
				<th>ISBN</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th>${libro.id}</th>
					<td>${libro.titulo}</td>
					<td>${libro.autor}</td>
					<td>${libro.isbn}</td>
					<td>${libro.precio}</td>
				</tr>
			</c:forEach>

			<%-- 		<% for(Libro libro: (Iterable<Libro>)request.getAttribute("libros")) { %> --%>

			<%-- 			<th><%=libro.getId() %></th> --%>
			<%-- 			<td><%=libro.getTitulo() %></td> --%>
			<%-- 			<td><%=libro.getAutor() %></td> --%>
			<%-- 			<td><%=libro.getIsbn() %></td> --%>
			<%-- 			<td><%=libro.getPrecio() %></td> --%>

			<%-- 		<% } %> --%>
		</tbody>
	</table>

</body>
</html>
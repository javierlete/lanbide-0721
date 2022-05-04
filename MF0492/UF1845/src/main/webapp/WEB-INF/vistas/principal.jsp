<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!-- 	import="com.ipartek.formacion.uf1845.modelos.*" -->
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<h1>Principal</h1>

	<table class="table table-hover table-striped table-bordered">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Autor</th>
				<th>ISBN</th>
				<th>Precio</th>
				<th>Opciones</th>
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
					<td>
						<a class="btn btn-primary" href="admin/formulario?id=${libro.id}">Editar</a>
						<a class="btn btn-danger" href="admin/borrar?id=${libro.id}">Borrar</a>
					</td>
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
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a class="btn btn-primary" href="admin/formulario">Añadir</a>
				</td>
			</tr>
		</tfoot>
	</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-sm table-hover table-striped table-bordered">
		<thead>
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
			<c:forEach items="${carrito}" var="libro">
				<tr>
					<th>${libro.id}</th>
					<td>${libro.titulo}</td>
					<td>${libro.autor}</td>
					<td>${libro.isbn}</td>
					<td>${libro.precio}</td>
					<td>
						<a class="btn btn-danger" href="carrito?opcion=quitar&id=${libro.id}">Quitar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a class="btn btn-primary" href="index">Añadir</a>
					<a class="btn btn-warning" href="factura">Facturar</a>
				</td>
			</tr>
		</tfoot>
	</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
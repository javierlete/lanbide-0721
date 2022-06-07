<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-bordered table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Marca</th>
			<th>Alto</th>
			<th>Ancho</th>
			<th>Precio</th>
			<th>Tipo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pizarras}" var="p">
			<tr>
				<th>${p.id}</th>
				<td>${p.marca}</td>
				<td>${p.altoEnMm}</td>
				<td>${p.anchoEnMm}</td>
				<td>${p.precio}</td>
				<td>${p.tipo}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	$(function() {
		$('table').DataTable({
			language : {
				url : 'json/es-ES.json'
			}
		});
	});
</script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>

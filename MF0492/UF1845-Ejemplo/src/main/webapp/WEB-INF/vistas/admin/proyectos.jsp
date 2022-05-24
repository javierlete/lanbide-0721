<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-bordered table-striped mt-3">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Presupuesto</th>
			<th>Inicio</th>
			<th>Fin</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${proyectos}" var="p">
			<tr>
				<th>${p.id}</th>
				<td>${p.nombre}</td>
				<td>${p.presupuesto}</td>
				<td>${p.inicio}</td>
				<td>${p.fin}</td>
				<td>
					<a class="btn btn-primary btn-sm" href="#">Editar</a>
					<a class="btn btn-danger btn-sm" href="#">Borrar</a>
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
				<a class="btn btn-primary btn-sm" href="#">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<script>
$(function () {
    $('table').DataTable({
        language: {
            url: 'json/es-ES.json'
        }
    });
} );
</script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
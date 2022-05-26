<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-bordered table-striped mt-3">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Descuento</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="l">
			<tr>
				<th>${l.id}</th>
				<td>${l.nombre}</td>
				<td><fmt:formatNumber type="currency" value="${l.precio}"></fmt:formatNumber></td>
				<td><fmt:formatNumber type="percent" value="${l.descuento/100}"></fmt:formatNumber></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</tfoot>
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

<form action="index" method="post" class="mt-3">
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control ${libro.errores.nombre != null ? 'is-invalid' : '' }"
				id="nombre" name="nombre" value="${libro.nombre}">
			<div class="invalid-feedback">${libro.errores.nombre}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm-10">
			<input type="number" step=".01"
				class="form-control ${libro.errores.precio != null ? 'is-invalid' : '' }"
				id="precio" name="precio" value="${libro.precio}">
			<div class="invalid-feedback">${libro.errores.precio}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="descuento" class="col-sm-2 col-form-label">Descuento</label>
		<div class="col-sm-10">
			<input type="number"
				class="form-control ${libro.errores.descuento != null ? 'is-invalid' : '' }"
				id="descuento" name="descuento" value="${libro.descuento}">
			<div class="invalid-feedback">${libro.errores.descuento}</div>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Añadir</button>
			<a href="index" class="btn btn-secondary">Cancelar</a>
		</div>
	</div>
</form>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>

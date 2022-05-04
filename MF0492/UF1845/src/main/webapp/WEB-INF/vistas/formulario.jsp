<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

	<h1>Formulario</h1>

	<form action="admin/formulario" method="post">
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" name="id" value="${libro.id}" readonly >
				<span class="text-danger">${libro.errores.id}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="titulo" class="col-sm-2 col-form-label">Título</label>
			<div class="col-sm-10">
				<input type="text" class="form-control ${libro.errores.titulo != null ? 'is-invalid' : '' }" name="titulo" value="${libro.titulo}">
				<div class="invalid-feedback">${libro.errores.titulo}</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="autor" class="col-sm-2 col-form-label">Autor</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="autor" value="${libro.autor}">
				<span class="text-danger">${libro.errores.autor}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="isbn" value="${libro.isbn}">
				<span class="text-danger">${libro.errores.isbn}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm-10">
				<input type="number" step=".01" class="form-control ${libro.errores.precio != null ? 'is-invalid' : '' }" name="precio" value="${libro.precio}">
				<div class="invalid-feedback">${libro.errores.precio}</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="offset-sm-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</div>
	</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>
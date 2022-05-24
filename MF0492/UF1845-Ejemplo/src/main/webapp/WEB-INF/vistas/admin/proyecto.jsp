<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/proyecto" method="post" class="mt-3">
	<input type="hidden" name="op" value="${op}" />
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control ${proyecto.errores.id != null ? 'is-invalid' : '' }" id="id" name="id"
				value="${proyecto.id}">
			<div class="invalid-feedback">${proyecto.errores.id}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control ${proyecto.errores.nombre != null ? 'is-invalid' : '' }" id="nombre" name="nombre"
			value="${proyecto.nombre}" ${op == 'borrar' ? 'disabled' : '' }>
			<div class="invalid-feedback">${proyecto.errores.nombre}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="presupuesto" class="col-sm-2 col-form-label">Presupuesto</label>
		<div class="col-sm-10">
			<input type="number" step=".01" class="form-control ${proyecto.errores.presupuesto != null ? 'is-invalid' : '' }" id="presupuesto" name="presupuesto"
			value="${proyecto.presupuesto}" ${op == 'borrar' ? 'disabled' : '' }>
			<div class="invalid-feedback">${proyecto.errores.presupuesto}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="inicio" class="col-sm-2 col-form-label">Inicio</label>
		<div class="col-sm-10">
			<input type="date" class="form-control ${proyecto.errores.inicio != null ? 'is-invalid' : '' }" id="inicio" name="inicio"
			value="${proyecto.inicio}" ${op == 'borrar' ? 'disabled' : '' }>
			<div class="invalid-feedback">${proyecto.errores.inicio}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="fin" class="col-sm-2 col-form-label">Fin</label>
		<div class="col-sm-10">
			<input type="date" class="form-control ${proyecto.errores.fin != null ? 'is-invalid' : '' }" id="fin" name="fin"
			value="${proyecto.fin}" ${op == 'borrar' ? 'disabled' : '' }>
			<div class="invalid-feedback">${proyecto.errores.fin}</div>
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">
			<c:choose>
				<c:when test="${op == 'agregar'}">Añadir</c:when>
				<c:when test="${op == 'editar'}">Editar</c:when>
				<c:when test="${op == 'borrar'}">Borrar</c:when>
				<c:otherwise>¡¿QUEEEEEE?!</c:otherwise>				
			</c:choose>
			</button>
			<a href="admin/proyectos" class="btn btn-secondary">Cancelar</a>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="http://placeimg.com/480/640/any?${libro.id}"
				class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${libro.titulo}</h5>
				<p class="card-text text-end">
					<fmt:formatNumber type="currency" value="${libro.precio}" />
				</p>
				<p class="card-text text-end">
					<a href="carrito?opcion=agregar&id=${libro.id}"
						class="btn btn-primary stretched-link">Al carrito</a>
				</p>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
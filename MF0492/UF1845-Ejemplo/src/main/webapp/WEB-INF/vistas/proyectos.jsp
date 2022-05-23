<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div
	class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
	<c:forEach items="${proyectos}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="http://placeimg.com/640/480/people?${p.id}" class="card-img-top"
					alt="...">
				<div class="card-body">
					<h5 class="card-title">${p.nombre}</h5>
					<p class="card-text">
						<fmt:formatNumber type="currency" value="${p.presupuesto}"></fmt:formatNumber>
					</p>
				</div>
				<div class="card-footer">
					De <small class="text-muted">${p.inicio}</small><br />
					a
					<small class="text-muted">${p.fin}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
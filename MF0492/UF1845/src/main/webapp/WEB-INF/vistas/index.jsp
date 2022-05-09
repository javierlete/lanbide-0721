<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="py-4 row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
	<c:forEach items="${libros}" var="libro">
		<div class="col">
			<div class="card h-100">
				<img src="http://placeimg.com/240/320/any?${libro.id}" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${libro.titulo}</h5>
					<p class="card-text text-end">
						<fmt:formatNumber type="currency" value="${libro.precio}" />
					</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">${libro.isbn}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
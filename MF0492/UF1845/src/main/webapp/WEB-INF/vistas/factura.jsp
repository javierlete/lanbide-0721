<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<div class="col">
		<h2>LibroApp Enterprise</h2>
		<p>Dirección</p>
		<p>CP</p>
		<p>Provincia</p>
		<p>CIF</p>
	</div>
	<div class="col text-end">
		<h2>${factura.cliente.nombre}</h2>
		<p>${factura.cliente.direccion}</p>
		<p>${factura.cliente.codigoPostal}</p>
		<p>${factura.cliente.provincia}</p>
		<p>${factura.cliente.cif}</p>
		<p>${factura.fecha}</p>
		<p>${factura.numero}</p>
	</div>
</div>

<div class="row">
	<div class="col">
		<div class="table-responsive">
			<table
				class="table table-sm table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Autor</th>
						<th>ISBN</th>
						<th>Precio Unidad</th>
						<th>Cantidad</th>
						<th>Precio</th>
						<th>IVA</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${factura.lineas}" var="linea">
						<tr>
							<th>${linea.libro.id}</th>
							<td>${linea.libro.titulo}</td>
							<td>${linea.libro.autor}</td>
							<td>${linea.libro.isbn}</td>
							<td>${linea.libro.precio}</td>
							<td>${linea.cantidad}</td>
							<td><fmt:formatNumber type="currency"
									value="${linea.precio}" /></td>
							<td><fmt:formatNumber type="currency" value="${linea.iva}" /></td>
							<td><fmt:formatNumber type="currency" value="${linea.total}" /></td>
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
						<td></td>
						<td><fmt:formatNumber type="currency"
								value="${factura.precio}" /></td>
						<td><fmt:formatNumber type="currency" value="${factura.iva}" /></td>
						<td><fmt:formatNumber type="currency"
								value="${factura.total}" /></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="d-flex">
	<div>
		<h2>LibroApp Enterprise</h2>
		<p>Dirección</p>
		<p>CP</p>
		<p>Provincia</p>
		<p>CIF</p>
	</div>
	<div class="ms-auto">
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
						<th class="text-end">Id</th>
						<th>Título</th>
						<th>Autor</th>
						<th>ISBN</th>
						<th class="text-end">Precio Unidad</th>
						<th class="text-end">Cantidad</th>
						<th class="text-end">Precio</th>
						<th class="text-end">IVA</th>
						<th class="text-end">Total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${factura.lineas}" var="linea">
						<tr>
							<th class="text-end">${linea.libro.id}</th>
							<td>${linea.libro.titulo}</td>
							<td>${linea.libro.autor}</td>
							<td>${linea.libro.isbn}</td>
							<td class="text-end"><fmt:formatNumber type="currency"
									value="${linea.libro.precio}" /></td>
							<td class="text-end">${linea.cantidad}</td>
							<td class="text-end"><fmt:formatNumber type="currency"
									value="${linea.precio}" /></td>
							<td class="text-end"><fmt:formatNumber type="currency"
									value="${linea.iva}" /></td>
							<td class="text-end"><fmt:formatNumber type="currency"
									value="${linea.total}" /></td>
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
						<td class="text-end"><fmt:formatNumber type="currency"
								value="${factura.precio}" /></td>
						<td class="text-end"><fmt:formatNumber type="currency"
								value="${factura.iva}" /></td>
						<td class="text-end"><fmt:formatNumber type="currency"
								value="${factura.total}" /></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
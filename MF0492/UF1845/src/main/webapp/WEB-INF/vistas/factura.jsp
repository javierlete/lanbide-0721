<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<!-- Replace "test" with your own sandbox Business account app client ID -->
<script src="https://www.paypal.com/sdk/js?client-id=AaFce3GSUi8_VReV_xuhFLU9QCTFlvKe7z75z75M8G7BxCPKJ73BZQ-Ca_hs07Y1xZFJR6faQxRPdA6v&currency=EUR"></script>
<!-- Set up a container element for the button -->
<div id="paypal-button-container"></div>
<script>
      paypal.Buttons({
        // Sets up the transaction when a payment button is clicked
        createOrder: (data, actions) => {
          return actions.order.create({
            purchase_units: [{
              amount: {
                value: '${factura.total}' // Can also reference a variable or function
              }
            }]
          });
        },
        // Finalize the transaction after payer approval
        onApprove: (data, actions) => {
          return actions.order.capture().then(function(orderData) {
            // Successful capture! For dev/demo purposes:
            console.log('Capture result', orderData, JSON.stringify(orderData, null, 2));
            const transaction = orderData.purchase_units[0].payments.captures[0];
            alert(`Transaction ${transaction.status}: ${transaction.id}\n\nSee console for all available details`);
            // When ready to go live, remove the alert and show a success message within this page. For example:
            // const element = document.getElementById('paypal-button-container');
            // element.innerHTML = '<h3>Thank you for your payment!</h3>';
            // Or go to another URL:  actions.redirect('thank_you.html');
          });
        }
      }).render('#paypal-button-container');
    </script>

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
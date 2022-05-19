package com.ipartek.formacion.uf1845.controladores;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

import com.ipartek.formacion.uf1845.configuracion.*;
import com.ipartek.formacion.uf1845.modelos.*;
import com.paypal.http.*;
import com.paypal.http.exceptions.*;
import com.paypal.orders.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/pagar")
public class PagarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Libro> carrito = (ArrayList<Libro>) request.getSession().getAttribute("carrito");
		
		Stream<Libro> streamLibros = carrito.stream();
		Stream<BigDecimal> streamPrecios = streamLibros.map(libro -> libro.getPrecio());
		Optional<BigDecimal> totalOptional = streamPrecios.reduce((total, precio) -> total.add(precio));
		BigDecimal total = totalOptional.orElse(null);
		total = total.round(new MathContext(2));
		
		total = total.multiply(BigDecimal.ONE.add(Factura.IVA));
		
		Order order = null;
		// Construct a request object and set desired parameters
		// Here, OrdersCreateRequest() creates a POST request to /v2/checkout/orders
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.checkoutPaymentIntent("CAPTURE");
		List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
		purchaseUnits.add(new PurchaseUnitRequest()
				.amountWithBreakdown(new AmountWithBreakdown().currencyCode("EUR").value(total.toString())));
		orderRequest.purchaseUnits(purchaseUnits);
		OrdersCreateRequest requestPaypal = new OrdersCreateRequest().requestBody(orderRequest);

		try {
			// Call API with your client and get a response for your call
			HttpResponse<Order> responsePaypal = Credentials.client.execute(requestPaypal);

			// If call returns body in response, you can get the de-serialized version by
			// calling result() on the response
			order = responsePaypal.result();
			System.out.println("Order ID: " + order.id());
			
			request.getSession().setAttribute("orderId", order.id());
			request.getSession().setAttribute("total", total);
			
			Stream<LinkDescription> stream = order.links().stream();
			Stream<LinkDescription> filtrados = stream.filter(link -> link.rel().equals("approve"));
			Optional<LinkDescription> primero = filtrados.findFirst();
			LinkDescription approve = primero.orElse(null);

			response.sendRedirect(approve.href());
			
			// .forEach(link -> System.out.println(link.rel() + " => " + link.method() + ":" + link.href()));
		} catch (IOException ioe) {
			if (ioe instanceof HttpException) {
				// Something went wrong server-side
				HttpException he = (HttpException) ioe;
				response.getWriter().println(he.getMessage());
				he.headers().forEach(x -> {
					try {
						response.getWriter().println(x + " :" + he.headers().header(x));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			} else {
				// Something went wrong client-side
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

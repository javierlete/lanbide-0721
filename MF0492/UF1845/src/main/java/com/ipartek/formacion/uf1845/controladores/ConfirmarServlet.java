package com.ipartek.formacion.uf1845.controladores;

import java.io.*;
import java.math.*;

import com.ipartek.formacion.uf1845.configuracion.*;
import com.paypal.http.*;
import com.paypal.http.exceptions.*;
import com.paypal.orders.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/confirmar")
public class ConfirmarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order order = null;
		
		String orderId = (String) request.getSession().getAttribute("orderId");
		
		OrdersCaptureRequest requestPaypal = new OrdersCaptureRequest(orderId);

		try {
			// Call API with your client and get a response for your call
			HttpResponse<Order> responsePaypal = Credentials.client.execute(requestPaypal);

			// If call returns body in response, you can get the de-serialized version by
			// calling result() on the response
			order = responsePaypal.result();
			System.out.println("Capture ID: " + order.purchaseUnits().get(0).payments().captures().get(0).id());
			order.purchaseUnits().get(0).payments().captures().get(0).links()
					.forEach(link -> System.out.println(link.rel() + " => " + link.method() + ":" + link.href()));
			
			BigDecimal totalRecibido = new BigDecimal(order.purchaseUnits().get(0).payments().captures().get(0).amount().value());
			
			BigDecimal total = (BigDecimal) request.getSession().getAttribute("total");
			
			if(total.compareTo(totalRecibido) == 0) {
				response.sendRedirect("factura");
			} else {
				// Mandar a tomar por...
			}
			
		} catch (IOException ioe) {
			if (ioe instanceof HttpException) {
				// Something went wrong server-side
				HttpException he = (HttpException) ioe;
				System.out.println(he.getMessage());
				he.headers().forEach(x -> System.out.println(x + " :" + he.headers().header(x)));
			} else {
				// Something went wrong client-side
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

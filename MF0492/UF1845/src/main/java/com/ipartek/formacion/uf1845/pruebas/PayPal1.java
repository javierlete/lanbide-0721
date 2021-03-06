package com.ipartek.formacion.uf1845.pruebas;

import java.io.*;
import java.util.*;

import com.ipartek.formacion.uf1845.configuracion.*;
import com.paypal.http.*;
import com.paypal.http.exceptions.*;
import com.paypal.orders.*;

public class PayPal1 {

	public static void main(String[] args) {
		Order order = null;
		// Construct a request object and set desired parameters
		// Here, OrdersCreateRequest() creates a POST request to /v2/checkout/orders
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.checkoutPaymentIntent("CAPTURE");
		List<PurchaseUnitRequest> purchaseUnits = new ArrayList<>();
		purchaseUnits
				.add(new PurchaseUnitRequest().amountWithBreakdown(new AmountWithBreakdown().currencyCode("EUR").value("86.25")));
		orderRequest.purchaseUnits(purchaseUnits);
		OrdersCreateRequest request = new OrdersCreateRequest().requestBody(orderRequest);

		try {
			// Call API with your client and get a response for your call
			HttpResponse<Order> response = Credentials.client.execute(request);

			// If call returns body in response, you can get the de-serialized version by
			// calling result() on the response
			order = response.result();
			System.out.println("Order ID: " + order.id());
			order.links().forEach(link -> System.out.println(link.rel() + " => " + link.method() + ":" + link.href()));
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

}

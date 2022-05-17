package com.ipartek.formacion.uf1845.controladores;

import java.io.*;
import java.time.*;
import java.util.*;

import com.ipartek.formacion.uf1845.configuracion.*;
import com.ipartek.formacion.uf1845.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/factura")
public class FacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Libro> carrito = (ArrayList<Libro>)request.getSession().getAttribute("carrito");
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		Long id = usuario.getId();
		
		Cliente cliente = Globales.daoClientes.obtenerPorId(id);
		
		Factura factura = new Factura(null, LocalDate.now(), "001", cliente);
		
		for(Libro libro: carrito) {
			factura.getLineas().add(new Linea(libro, 1));
		}
		
		request.setAttribute("factura", factura);
		
		request.getRequestDispatcher("/WEB-INF/vistas/factura.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

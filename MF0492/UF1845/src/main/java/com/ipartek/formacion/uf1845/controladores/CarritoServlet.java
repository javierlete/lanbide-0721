package com.ipartek.formacion.uf1845.controladores;

import static com.ipartek.formacion.uf1845.configuracion.Globales.*;

import java.io.*;
import java.util.*;

import com.ipartek.formacion.uf1845.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		String id = request.getParameter("id");

		@SuppressWarnings("unchecked")
		ArrayList<Libro> carrito = (ArrayList<Libro>) request.getSession().getAttribute("carrito");
		
		switch (opcion) {
		case "quitar":
			carrito.remove(daoLibros.obtenerPorId(Long.parseLong(id)));
			break;
		case "agregar":
			carrito.add(daoLibros.obtenerPorId(Long.parseLong(id)));
		case "ver":
			break;
		default:
			throw new ServletException("No tengo esa opción");
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

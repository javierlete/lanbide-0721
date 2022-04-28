package com.ipartek.formacion.uf1845.servlets;

import java.io.*;
import java.math.*;
import java.util.*;

import com.ipartek.formacion.uf1845.modelo.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/libro")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final TreeMap<Long, Libro> libros = new TreeMap<>();

	static {
		for (long i = 1; i <= 10; i++) {
			libros.put(i, new Libro(i, "Libro" + i, "Autor" + i, "ISBN" + i, new BigDecimal(i)));
		}
	}

	private PrintWriter out;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out = response.getWriter();

		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String isbn = request.getParameter("isbn");
		String precio = request.getParameter("precio");

		Libro libro = new Libro(null, titulo, autor, isbn, null);
		
		try {
			libro.setId(Long.parseLong(id));
		} catch (NumberFormatException e) {
			
		}
		
		try {
			libro.setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			
		}

		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "list":
			listar();
			break;
		case "find":
			buscar(libro.getId());
			break;
		case "add":
			listar();
			agregar(libro);
			listar();
			break;
		case "update":
			listar();
			modificar(libro);
			listar();
			break;
		case "delete":
			listar();
			borrar(libro.getId());
			listar();
			break;
		}

	}

	private void listar() {
		for (Libro libro : libros.values()) {
			out.println(libro);
		}
	}

	private void buscar(Long id) {
		out.println(libros.get(id));
	}

	private void agregar(Libro libro) {
		Long id = libros.size() > 0 ? libros.lastKey() + 1L: 1L;
		libro.setId(id);
		libros.put(libro.getId(), libro);
	}

	private void modificar(Libro libro) {
		libros.put(libro.getId(), libro);
	}

	private void borrar(Long id) {
		libros.remove(id);
	}

}

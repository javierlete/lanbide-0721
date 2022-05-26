package com.ipartek.formacion.l0721.mf0492.uf1845.examen.dal;

import java.io.*;

import com.ipartek.formacion.l0721.mf0492.uf1845.examen.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final String INDEX_JSP = "/WEB-INF/vistas/index.jsp";

	private static final long serialVersionUID = 1L;

	private static final DaoLibro DAO = DaoLibroMemoria.getInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libros", DAO.obtenerTodos());
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descuento = request.getParameter("descuento");
		
		Libro libro = new Libro(null, nombre, precio, descuento);
		
		if(libro.getErrores().size() > 0) {
			request.setAttribute("libro", libro);
			request.getRequestDispatcher(INDEX_JSP).forward(request, response);
			return;
		}
		
		DAO.insertar(libro);
		doGet(request, response);
	}
}

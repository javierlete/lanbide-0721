package com.ipartek.formacion.uf1845.controladores;

import static com.ipartek.formacion.uf1845.configuracion.Globales.*;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libros", dao.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

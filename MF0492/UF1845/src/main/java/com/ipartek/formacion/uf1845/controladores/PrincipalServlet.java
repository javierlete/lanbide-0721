package com.ipartek.formacion.uf1845.controladores;

import java.io.*;

import com.ipartek.formacion.uf1845.dal.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/admin/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final DaoLibros dao = DaoLibrosMemoria.getInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libros", dao.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/principal.jsp").forward(request, response);
	}

}

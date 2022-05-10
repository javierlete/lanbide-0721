package com.ipartek.formacion.uf1845.controladores;

import static com.ipartek.formacion.uf1845.configuracion.Globales.*;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		request.setAttribute("libro", dao.obtenerPorId(Long.parseLong(id)));
		request.getRequestDispatcher("/WEB-INF/vistas/detalle.jsp").forward(request, response);
	}

}

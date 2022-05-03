package com.ipartek.formacion.uf1845.controladores;

import java.io.*;
import java.math.*;

import com.ipartek.formacion.uf1845.dal.*;
import com.ipartek.formacion.uf1845.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DaoLibros dao = DaoLibrosMemoria.getInstancia();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null) {
			Libro libro = dao.obtenerPorId(Long.parseLong(id));
			request.setAttribute("libro", libro);
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String isbn = request.getParameter("isbn");
		String precio = request.getParameter("precio");
		
		Long idLong = id.trim().length() > 0 ? Long.parseLong(id) : null;
		
		Libro libro = new Libro(idLong, titulo, autor, isbn, new BigDecimal(precio));
		
		if(idLong == null) {
			dao.insertar(libro);
		} else {
			dao.modificar(libro);
		}
		
		response.sendRedirect("principal");
	}

}

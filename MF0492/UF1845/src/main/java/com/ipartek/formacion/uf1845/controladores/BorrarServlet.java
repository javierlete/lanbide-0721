package com.ipartek.formacion.uf1845.controladores;

import java.io.*;

import com.ipartek.formacion.uf1845.dal.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final DaoLibros dao = DaoLibrosMemoria.getInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		dao.borrar(Long.parseLong(id));
		
		response.sendRedirect("principal");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

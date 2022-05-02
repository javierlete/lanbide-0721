package com.ipartek.formacion.uf1845.controladores;

import java.io.*;

import com.ipartek.formacion.uf1845.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.sendRedirect("login.jsp"); // Cambia la URL
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response); 
		// NO cambia la URL
		// Conserva el objeto request
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger los datos de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Empaquetar en un objeto del modelo
		Usuario usuario = new Usuario(null, email, password);
		
		// Ejecutar la lógica de negocio
		Usuario validado = validarUsuario(usuario);
		
		if(validado == null) {
			// Empaquetar modelo para la vista
			request.setAttribute("usuario", usuario);
			request.setAttribute("mensaje", "El usuario o la contraseña no son válidos");
			
			// Saltar a la vista
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		} else {
			// Empaquetar modelo para la vista
			request.getSession().setAttribute("usuario", usuario);
			
			// Saltar a la vista
			response.sendRedirect("principal");
		}
	}
	
	private Usuario validarUsuario(Usuario usuario) {
		if("javier@lete.net".equals(usuario.getEmail()) && "contra".equals(usuario.getPassword())) {
			return usuario;
		}
		
		return null;
	}

}

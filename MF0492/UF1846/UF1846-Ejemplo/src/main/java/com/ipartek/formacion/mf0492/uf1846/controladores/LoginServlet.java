package com.ipartek.formacion.mf0492.uf1846.controladores;

import java.io.*;

import com.ipartek.formacion.mf0492.uf1846.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Globales.RAIZ_VISTAS + "/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(null, email, password);
		
		Usuario validado = validarUsuario(usuario);
		
		if(validado != null) {
			request.getSession().setAttribute("usuario", validado);
			response.sendRedirect(request.getContextPath() + "/admin");
		} else {
			request.setAttribute("usuario", usuario);
			//request.getRequestDispatcher(Globales.RAIZ_VISTAS + "/login.jsp").forward(request, response);
			doGet(request, response);
		}
	}

	private Usuario validarUsuario(Usuario usuario) {
		if(usuario.getEmail().contains("javier") &&
				usuario.getPassword().equals("pass")) {
			usuario.setId(5L);
			return usuario;
		}
		
		return null;
		
	}

}

package com.ipartek.formacion.mf0492.uf1845.ejemplo.controladores;

import java.io.*;

import com.ipartek.formacion.mf0492.uf1845.ejemplo.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Globales.VISTAS + "/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(null, email, password, null);
		
		Usuario usuarioValidado = validarUsuario(usuario);
		
		if(usuarioValidado != null) {
			request.getSession().setAttribute("usuario", usuarioValidado);
			
			if(usuarioValidado.getRol().equals("ADMIN")) {
				response.sendRedirect(request.getContextPath() + "/admin/proyectos");
			} else {
				response.sendRedirect(request.getContextPath() + "/proyectos");
			}
		} else {
			request.setAttribute("error", "El usuario o la contraseña son incorrectos");
			request.getRequestDispatcher(Globales.VISTAS + "/login.jsp").forward(request, response);
		}
	}

	private Usuario validarUsuario(Usuario usuario) {
		Usuario validado = Globales.DAO_USUARIO.obtenerUsuarioPorEmail(usuario.getEmail());

		if(validado == null) {
			return null;
		}
		
		if(validado.getPassword().equals(usuario.getPassword())) {
			return validado;
		} else {
			return null;
		}
	}

}

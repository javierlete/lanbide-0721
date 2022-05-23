package com.ipartek.formacion.mf0492.uf1845.ejemplo.filtros;

import java.io.*;

import com.ipartek.formacion.mf0492.uf1845.ejemplo.controladores.*;
import com.ipartek.formacion.mf0492.uf1845.ejemplo.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter {
       
	private static final long serialVersionUID = 8419530173986020100L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario != null && usuario.getRol().equals("ADMIN")) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("error", "Para entrar en administración tienes que estar logueado con un usuario administrador");
			req.getRequestDispatcher(Globales.VISTAS + "/login.jsp").forward(req, res);
		}
	}
}

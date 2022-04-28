package com.ipartek.formacion.uf1845.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double resultado = null;
		Double x, y;
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String op = request.getParameter("op");
		
		x = Double.parseDouble(a);
		y = Double.parseDouble(b);
		
		switch(op.charAt(0)) {
		case '+': resultado = x + y; break;
		case '-': resultado = x - y; break;
		case '*': resultado = x * y; break;
		case '/': resultado = x / y; break;
		default: resultado = null;
		}
		
		response.setContentType("text/plain");
		
		response.getWriter().println(resultado);
	}
}

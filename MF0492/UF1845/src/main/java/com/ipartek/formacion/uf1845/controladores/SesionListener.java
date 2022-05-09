package com.ipartek.formacion.uf1845.controladores;

import java.util.*;

import com.ipartek.formacion.uf1845.modelos.*;

import jakarta.servlet.http.*;

public class SesionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setAttribute("carrito", new ArrayList<Libro>());
	}
	
}

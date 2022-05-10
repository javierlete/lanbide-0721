package com.ipartek.formacion.uf1845.listeners;

import java.util.*;

import com.ipartek.formacion.uf1845.modelos.*;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebListener
public class SesionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setAttribute("carrito", new ArrayList<Libro>());
	}
	
}

package com.ipartek.formacion.mf0492.uf1845.ejemplo.controladores.admin;

import java.io.*;

import com.ipartek.formacion.mf0492.uf1845.ejemplo.controladores.*;
import com.ipartek.formacion.mf0492.uf1845.ejemplo.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/admin/proyecto")
public class AdminProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		
		Long idLong = null;
		
		if(id != null) {
			idLong = Long.parseLong(id);
		}
		
		request.setAttribute("op", op);
		
		switch(op) {
		case "borrar":
		case "editar":
			request.setAttribute("proyecto", Globales.DAO.obtenerPorId(idLong));
		case "agregar":
			request.getRequestDispatcher(Globales.VISTAS + "/admin/proyecto.jsp").forward(request, response);
			break;
		default:
			throw new RuntimeException("Opción no esperada: " + op);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String presupuesto = request.getParameter("presupuesto");
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		
		Long idLong = null;
		
		if(id != null && id.trim().length() > 0) {
			idLong = Long.parseLong(id);
		}
		
		Proyecto proyecto = null;
		
		if(!op.equals("borrar")) {
			proyecto = new Proyecto(id, nombre, presupuesto, inicio, fin);
			
			if(proyecto.getErrores().size() > 0) {
				request.setAttribute("texto", "Revisa los datos introducidos");
				request.setAttribute("nivel", "danger");
				request.setAttribute("proyecto", proyecto);
				request.setAttribute("op", op);
				
				request.getRequestDispatcher(Globales.VISTAS + "/admin/proyecto.jsp").forward(request, response);
				return;
			}
		}
		
		String texto = null;
		String nivel = "success";
		
		switch(op) {
		case "borrar":
			Globales.DAO.borrar(idLong);
			texto = "Se ha borrado correctamente el id " + idLong;
			break;
		case "editar":
			Globales.DAO.modificar(proyecto);
			texto = "Se ha modificado el proyecto " + proyecto.getId();
			break;
		case "agregar":
			proyecto = Globales.DAO.insertar(proyecto);
			texto = "Se ha añadido el proyecto " + proyecto.getId();
			break;
		default:
			throw new RuntimeException("Opción no esperada: " + op);
		}
		
		request.setAttribute("texto", texto);
		request.setAttribute("nivel", nivel);
		request.getRequestDispatcher("/admin/proyectos").forward(request, response);
	}
}

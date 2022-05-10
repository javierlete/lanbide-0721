package com.ipartek.formacion.uf1845.controladores;

import static com.ipartek.formacion.uf1845.configuracion.Globales.*;

import java.io.*;

import com.ipartek.formacion.uf1845.modelos.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/admin/formulario")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "uploads";
	
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
		
		Libro libro = new Libro(id, titulo, autor, isbn, precio);
		
		if(libro.tieneErrores()) {
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
			
			return;
		}
		
		if(libro.getId() == null) {
			libro = dao.insertar(libro);
		} else {
			dao.modificar(libro);
		}
		
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		String fileName;
		
		for (Part part : request.getParts()) {
		    fileName = part.getSubmittedFileName();
		    
		    System.out.println(fileName);
		    
		    if(fileName != null && fileName.trim().length() > 0) {
		    	part.write(uploadPath + File.separator + libro.getId() + ".jpg"); // fileName);
		    }
		}
		
		response.sendRedirect("principal");
	}

}

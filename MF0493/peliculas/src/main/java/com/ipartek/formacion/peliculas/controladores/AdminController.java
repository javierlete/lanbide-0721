package com.ipartek.formacion.peliculas.controladores;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.peliculas.servicios.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private PeliculaService servicio;
	
	@GetMapping
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/peliculas")
	public String peliculas(Model modelo) {
		modelo.addAttribute("peliculas", servicio.listado());
		return "admin/peliculas";
	}
}

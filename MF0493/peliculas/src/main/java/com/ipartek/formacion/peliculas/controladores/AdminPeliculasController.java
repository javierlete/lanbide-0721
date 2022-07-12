package com.ipartek.formacion.peliculas.controladores;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.peliculas.entidades.*;
import com.ipartek.formacion.peliculas.servicios.*;

import lombok.extern.java.*;

@Log
@Controller
@RequestMapping("/admin/peliculas")
public class AdminPeliculasController {
	@Autowired
	private GeneroService servicioGenero;
	@Autowired
	private PeliculaService servicio;
	
	@GetMapping
	public String peliculas(Model modelo) {
		modelo.addAttribute("peliculas", servicio.listado());
		return "admin/peliculas";
	}
	
	@GetMapping("/insertar")
	public String insertar(Pelicula pelicula, Model modelo) {
		modelo.addAttribute("generos", servicioGenero.obtenerGeneros());
		return "admin/pelicula";
	}

	@GetMapping("/{id}")
	public String editar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("generos", servicioGenero.obtenerGeneros());
		modelo.addAttribute("pelicula", servicio.obtenerPorId(id));
		return "admin/pelicula";
	}

	@GetMapping("/{id}/borrar")
	public String borrar(@PathVariable Long id) {
		servicio.borrar(id);
		return "redirect:/admin/peliculas";
	}
	
	@PostMapping
	public String postPelicula(@Valid Pelicula pelicula, BindingResult bindingResult, Model modelo) {
		log.info(pelicula.toString());
		log.info(pelicula.getGeneros().toString());
		
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("generos", servicioGenero.obtenerGeneros());
			return "admin/pelicula";
		}
		
		if(pelicula.getId() == null) {
			servicio.insertar(pelicula);
		} else {
			servicio.modificar(pelicula);
		}
		
		return "redirect:/admin/peliculas";
	}
}

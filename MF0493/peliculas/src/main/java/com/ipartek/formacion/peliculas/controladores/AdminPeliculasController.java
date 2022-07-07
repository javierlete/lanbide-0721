package com.ipartek.formacion.peliculas.controladores;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.peliculas.entidades.*;
import com.ipartek.formacion.peliculas.servicios.*;

@Controller
@RequestMapping("/admin/peliculas")
public class AdminPeliculasController {
	@Autowired
	private PeliculaService servicio;
	
	@GetMapping
	public String peliculas(Model modelo) {
		modelo.addAttribute("peliculas", servicio.listado());
		return "admin/peliculas";
	}
	
	@GetMapping("/insertar")
	public String insertar(Pelicula pelicula) {
		return "admin/pelicula";
	}

	@GetMapping("/{id}")
	public String editar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("pelicula", servicio.obtenerPorId(id));
		return "admin/pelicula";
	}

	@GetMapping("/{id}/borrar")
	public String borrar(@PathVariable Long id) {
		servicio.borrar(id);
		return "redirect:/admin/peliculas";
	}
	
	@PostMapping
	public String postPelicula(@Valid Pelicula pelicula, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
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

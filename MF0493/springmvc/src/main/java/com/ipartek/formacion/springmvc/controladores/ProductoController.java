package com.ipartek.formacion.springmvc.controladores;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.springmvc.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@GetMapping
	public String mostrarFormulario(Producto producto) {
		return "producto";
	}
	
	@PostMapping
	public String leerFormulario(Producto producto) {
		System.out.println(producto);
		return "producto";
	}
}

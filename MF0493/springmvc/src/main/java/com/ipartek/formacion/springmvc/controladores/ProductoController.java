package com.ipartek.formacion.springmvc.controladores;

import javax.validation.*;

import org.springframework.stereotype.*;
import org.springframework.validation.*;
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
	public String leerFormulario(@Valid Producto producto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "producto";
		} else {
			return "producto-mostrar";
		}
	}
}

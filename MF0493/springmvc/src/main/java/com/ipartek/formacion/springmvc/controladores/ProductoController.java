package com.ipartek.formacion.springmvc.controladores;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.springmvc.*;
import com.ipartek.formacion.springmvc.repositorios.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private DaoProducto dao;
	
	@GetMapping
	public String mostrarFormulario(Producto producto) {
		return "producto";
	}

	@PostMapping
	public String leerFormulario(@Valid Producto producto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "producto";
		} else {
			dao.insertar(producto);
			return "producto-mostrar";
		}
	}
}

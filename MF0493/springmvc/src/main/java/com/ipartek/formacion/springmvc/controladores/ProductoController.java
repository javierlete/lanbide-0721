package com.ipartek.formacion.springmvc.controladores;

import java.math.*;

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
	private ProductoRepository repo;
	
	@GetMapping
	public String mostrarFormulario(Producto producto) {
		return "producto";
	}

	@PostMapping
	public String leerFormulario(@Valid Producto producto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "producto";
		} else {
			repo.save(producto);
			return "producto-mostrar";
		}
	}
	
	@GetMapping("/{menor}/{mayor}")
	@ResponseBody
	public String mostrarProductosEntreMenorYMayor(@PathVariable BigDecimal menor, @PathVariable BigDecimal mayor) {
		return repo.findByPrecioBetween(menor, mayor).toString();
	}
}

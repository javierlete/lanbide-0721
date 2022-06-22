package com.ipartek.formacion.springmvc.controladores;

import java.math.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.springmvc.entidades.*;
import com.ipartek.formacion.springmvc.servicios.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService servicio;
	
	@GetMapping
	public String mostrarFormulario(Producto producto) {
		producto.setNombre("Valor inicial");
		producto.setPrecio(BigDecimal.ZERO);
		return "producto";
	}

	@PostMapping
	public String leerFormulario(@Valid Producto producto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "producto";
		} else {
			servicio.guardar(producto);
			return "producto-mostrar";
		}
	}
	
	@GetMapping("/{menor}/{mayor}")
	@ResponseBody
	public String mostrarProductosEntreMenorYMayor(@PathVariable BigDecimal menor, @PathVariable BigDecimal mayor) {
		return servicio.buscarPorPrecios(menor, mayor).toString();
	}
}

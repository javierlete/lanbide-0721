package com.ipartek.formacion.springmvc.controladores;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.springmvc.entidades.*;
import com.ipartek.formacion.springmvc.servicios.*;

@Controller
@RequestMapping("/admin")
public class AdminProductosController {
	@Autowired
	private ProductoService servicio;
	
	@GetMapping("/productos")
	public String obtenerTodos(Model modelo) {
		modelo.addAttribute("productos", servicio.obtenerTodos());
		return "adminproductos";
	}
	
	@GetMapping({"/producto", "/producto/{id}"})
	public String obtenerPorId(@PathVariable(required = false) Long id, Model modelo) {
		Producto producto;
		
		if(id == null) {
			producto = new Producto();
		} else {
			producto = servicio.obtenerPorId(id);
		}
		
		modelo.addAttribute("producto", producto);
		return "adminproducto";
	}
	
	@PostMapping("/producto")
	public String guardar(@Valid Producto producto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "adminproducto";
		} 
	
		System.out.println(producto);
		
		if(producto.getId() != null) {
			servicio.modificar(producto);
		} else {
			servicio.guardar(producto);
		}
		return "redirect:/admin/productos";
	}
	
	@GetMapping("/productos/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		servicio.borrarPorId(id);
		
		return "redirect:/admin/productos";
	}
}

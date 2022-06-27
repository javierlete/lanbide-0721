package com.ipartek.formacion.springmvc.controladores.api;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import com.ipartek.formacion.springmvc.entidades.*;
import com.ipartek.formacion.springmvc.servicios.*;

@RestController
@RequestMapping("/apirest/productos")
public class ProductoApiController {
	@Autowired
	private ProductoService servicio;
	
	@GetMapping
	public Iterable<Producto> obtenerTodos() {
		return servicio.obtenerTodos();
	}
	
	@GetMapping("{id}")
	public Producto obtenerProducto(@PathVariable Long id) {
		Producto producto = servicio.obtenerPorId(id);
		
		if(producto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		return producto;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Producto insertar(@RequestBody Producto producto) {
		servicio.guardar(producto);
		return producto;
	}
	
	@PutMapping("{id}")
	public Producto modificar(@PathVariable Long id, @RequestBody Producto producto) {
		if(servicio.obtenerPorId(id) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		servicio.modificar(producto);
		return producto;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable Long id) {
		if(id < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to change your format");
		}
		
		if(servicio.obtenerPorId(id) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		servicio.borrarPorId(id);
	}
}

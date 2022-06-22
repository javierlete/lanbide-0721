package com.ipartek.formacion.springmvc.servicios;

import java.math.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.ipartek.formacion.springmvc.entidades.*;
import com.ipartek.formacion.springmvc.repositorios.*;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repo;

	public Iterable<Producto> buscarPorPrecios(BigDecimal menor, BigDecimal mayor) {
		return repo.findByPrecioBetween(menor, mayor);
	}

	public void guardar(@Valid Producto producto) {
		repo.save(producto);		
	}

	public Iterable<Producto> obtenerTodos() {
		return repo.findAll();
	}

	public Producto obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	public void borrarPorId(Long id) {
		repo.deleteById(id);
	}

	public void modificar(@Valid Producto producto) {
		repo.save(producto);
	}
}

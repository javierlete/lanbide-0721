package com.ipartek.formacion.springmvc.repositorios;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.ipartek.formacion.springmvc.*;

@Repository
public class DaoProductoJpa implements DaoProducto {
	@Autowired
	private ProductoRepository repo;

	@Override
	public Iterable<Producto> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Producto insertar(Producto producto) {
		return repo.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		return repo.save(producto);
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);	
	}
	
	
}

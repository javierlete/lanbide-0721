package com.ipartek.formacion.springmvc.repositorios;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;

import com.ipartek.formacion.springmvc.*;

public class DaoProductoMySql implements DaoProducto {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Producto> obtenerTodos() {
		return jdbc.query("SELECT * FROM productos", new BeanPropertyRowMapper<>());
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM productos WHERE id=?", new BeanPropertyRowMapper<>(), id);
	}

	@Override
	public Producto insertar(Producto producto) {
		jdbc.update("INSERT INTO productos (nombre, precio) VALUES (?, ?)", producto.getNombre(), producto.getPrecio());
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		jdbc.update("UPDATE productos SET nombre = ?, precio = ? WHERE id = ?", producto.getNombre(), producto.getPrecio(), producto.getId());
		return producto;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM productos WHERE id = ?", id);
	}

}

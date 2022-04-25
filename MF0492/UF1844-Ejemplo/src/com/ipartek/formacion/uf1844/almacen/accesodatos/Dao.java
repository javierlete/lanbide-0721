package com.ipartek.formacion.uf1844.almacen.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default void insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default void modificar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}

package com.ipartek.formacion.mf0492.uf1846.dal;

interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DalException("No implementado");
	}
	default T obtenerPorId() {
		throw new DalException("No implementado");
	}
	
	default T insertar(T objeto) {
		throw new DalException("No implementado");
	}
	default T modificar(T objeto) {
		throw new DalException("No implementado");
	}
	default void borrar(Long id) {
		throw new DalException("No implementado");
	}
}

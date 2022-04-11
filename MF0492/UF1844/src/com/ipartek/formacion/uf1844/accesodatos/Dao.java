package com.ipartek.formacion.uf1844.accesodatos;

/**
 * Interface que define las características de un
 * Data Access Object
 * (Objeto de acceso a datos)
 * 
 * Las operaciones se corresponden con las de un CRUD
 * (Create Retrieve Update Delete)
 * (Altas, bajas, modificaciones y consultas)
 * @author javierlete
 *
 */
public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(long id);
	
	void insertar(T objeto);
	void modificar(T objeto);
	void borrar(long id);
}

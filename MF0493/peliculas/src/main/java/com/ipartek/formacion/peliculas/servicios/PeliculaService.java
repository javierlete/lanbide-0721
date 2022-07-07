package com.ipartek.formacion.peliculas.servicios;

import com.ipartek.formacion.peliculas.entidades.*;

public interface PeliculaService {
	Iterable<Pelicula> listado();
	Pelicula obtenerPorId(Long id);
	
	Pelicula insertar(Pelicula pelicula);
	Pelicula modificar(Pelicula pelicula);
	void borrar(Long id);
}

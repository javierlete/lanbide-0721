package com.ipartek.formacion.uf1845.dal;

import java.math.*;
import java.util.*;

import com.ipartek.formacion.uf1845.modelos.*;

public class DaoLibrosMemoria implements DaoLibros {

	static final TreeMap<Long, Libro> libros = new TreeMap<>();

	// SINGLETON
	private DaoLibrosMemoria() {
		for (long i = 1; i <= 10; i++) {
			libros.put(i, new Libro(i, "Libro" + i, "Autor" + i, "ISBN" + i, new BigDecimal(i)));
		}
	}

	private static final DaoLibrosMemoria INSTANCIA = new DaoLibrosMemoria();

	public static DaoLibrosMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return libros.get(id);
	}

	@Override
	public Libro insertar(Libro libro) {
		Long id = libros.size() > 0 ? libros.lastKey() + 1L : 1L;
		libro.setId(id);
		libros.put(libro.getId(), libro);

		return libro;
	}

	@Override
	public Libro modificar(Libro libro) {
		if(!libros.containsKey(libro.getId())) {
			throw new DalException("No existe el libro a modificar " + libro.getId());
		}
		
		libros.put(libro.getId(), libro);

		return libro;
	}

	@Override
	public void borrar(Long id) {
		if(!libros.containsKey(id)) {
			throw new DalException("No existe el libro a borrar " + id);
		}
		
		libros.remove(id);
	}

}

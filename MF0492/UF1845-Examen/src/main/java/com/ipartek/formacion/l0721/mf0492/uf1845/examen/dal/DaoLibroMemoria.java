package com.ipartek.formacion.l0721.mf0492.uf1845.examen.dal;

import java.util.*;

import com.ipartek.formacion.l0721.mf0492.uf1845.examen.modelos.*;

public class DaoLibroMemoria implements DaoLibro {

	private static final TreeMap<Long, Libro> libros = new TreeMap<>();
	
	static {
		libros.put(1L, new Libro("1", "Nombre1", "1234.11", "12"));
		libros.put(2L, new Libro("2", "Nombre2", "1234.12", "22"));
		libros.put(3L, new Libro("3", "Nombre3", "1234.13", "32"));
	}
	
	// SINGLETON
	private DaoLibroMemoria() {}
	private static final DaoLibroMemoria INSTANCIA = new DaoLibroMemoria();
	public static DaoLibroMemoria getInstancia() { return INSTANCIA; }
	// FIN SINGLETON
	
	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro insertar(Libro libro) {
		Long id = libros.size() > 0 ? libros.lastKey() + 1L : 1L;
		libro.setId(id);
		libros.put(id, libro);

		return libro;
	}

}

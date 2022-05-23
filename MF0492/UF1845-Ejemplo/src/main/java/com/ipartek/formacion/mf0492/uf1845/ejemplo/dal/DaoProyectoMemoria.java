package com.ipartek.formacion.mf0492.uf1845.ejemplo.dal;

import java.math.*;
import java.time.*;
import java.util.*;

import com.ipartek.formacion.mf0492.uf1845.ejemplo.modelos.*;

public class DaoProyectoMemoria implements DaoProyecto {
	private static final TreeMap<Long, Proyecto> proyectos = new TreeMap<>();

	static {
		proyectos.put(1L, new Proyecto(1L, "Prueba", new BigDecimal("12345"), LocalDate.of(2000, 1, 1),
				LocalDate.of(2010, 2, 5)));
		proyectos.put(2L, new Proyecto(2L, "Prueba2", new BigDecimal("212345"), LocalDate.of(2002, 1, 1),
				LocalDate.of(2012, 2, 5)));
		proyectos.put(3L, new Proyecto(3L, "Prueba3", new BigDecimal("312345"), LocalDate.of(2003, 1, 1),
				LocalDate.of(2013, 2, 5)));
	}

	// SINGLETON
	private DaoProyectoMemoria() {
	}

	private static final DaoProyectoMemoria INSTANCIA = new DaoProyectoMemoria();

	public static DaoProyectoMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Proyecto> obtenerTodos() {
		return proyectos.values();
	}

	@Override
	public Proyecto obtenerPorId(Long id) {
		return proyectos.get(id);
	}

	@Override
	public Proyecto insertar(Proyecto proyecto) {
		Long id = proyectos.size() > 0 ? proyectos.lastKey() + 1L : 1L;
		proyecto.setId(id);
		proyectos.put(id, proyecto);

		return proyecto;
	}

	@Override
	public Proyecto modificar(Proyecto proyecto) {
		proyectos.put(proyecto.getId(), proyecto);

		return proyecto;
	}

	@Override
	public void borrar(Long id) {
		proyectos.remove(id);
	}

}

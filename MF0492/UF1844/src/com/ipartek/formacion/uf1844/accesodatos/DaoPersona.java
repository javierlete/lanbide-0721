package com.ipartek.formacion.uf1844.accesodatos;

import java.util.*;

import com.ipartek.formacion.uf1844.poo.pojos.*;

public class DaoPersona implements Dao<Persona> {

	private static final TreeMap<Long, Persona> personas = new TreeMap<>() {
		private static final long serialVersionUID = 8577547240047673794L;

		{
			put(1L, new Persona(1L, "Javier"));
			put(2L, new Persona(2L, "Pepe"));
			put(3L, new Persona(3L, "Juan"));
		}
	};
	
	// Patrón Singleton
	private DaoPersona() {}
	private static final DaoPersona INSTANCIA = new DaoPersona();
	public static DaoPersona getInstancia() { return INSTANCIA; }
	// Fin Singleton
	
	@Override
	public Iterable<Persona> obtenerTodos() {
		return personas.values();
	}

	@Override
	public Persona obtenerPorId(long id) {
		return personas.get(id);
	}

	@Override
	public void insertar(Persona persona) {
		long id = personas.size() != 0 ? personas.lastKey() + 1L : 1L;
		
		persona.setId(id);
		
		personas.put(persona.getId(), persona);
	}

	@Override
	public void modificar(Persona persona) {
		personas.put(persona.getId(), persona);
	}

	@Override
	public void borrar(long id) {
		personas.remove(id);
	}

}

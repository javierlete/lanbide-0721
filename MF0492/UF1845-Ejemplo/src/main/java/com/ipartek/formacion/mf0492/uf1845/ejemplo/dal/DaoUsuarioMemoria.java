package com.ipartek.formacion.mf0492.uf1845.ejemplo.dal;

import java.util.*;

import com.ipartek.formacion.mf0492.uf1845.ejemplo.modelos.*;

public class DaoUsuarioMemoria implements DaoUsuario {
	private static final TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L, "javier@lete.net", "contra", "ADMIN"));
		usuarios.put(2L, new Usuario(2L, "pepe@perez.net", "pepe", "USER"));
		usuarios.put(3L, new Usuario(3L, "juan@gonzalez.net", "juan", "USER"));
	}

	// SINGLETON
	private DaoUsuarioMemoria() {
	}

	private static final DaoUsuarioMemoria INSTANCIA = new DaoUsuarioMemoria();

	public static final DaoUsuarioMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		Long id = usuarios.size() > 0 ? usuarios.lastKey() + 1L : 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);

		return usuario;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);

		return usuario;
	}

	@Override
	public void borrar(Long id) {
		usuarios.remove(id);
	}

}

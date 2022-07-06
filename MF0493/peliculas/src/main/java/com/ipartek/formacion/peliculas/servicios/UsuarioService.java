package com.ipartek.formacion.peliculas.servicios;

import com.ipartek.formacion.peliculas.entidades.*;

/**
 * Servicio para el tipo Usuario
 * @author javierlete
 *
 */
public interface UsuarioService {
	/**
	 * Método para comprobar si un usuario es correcto
	 * @param usuario Usuario a validar
	 * @return usuario completo
	 */
	Usuario validar(Usuario usuario);
	
	/**
	 * Obtener todos los usuarios
	 * @return lista de usuarios. Si no hay ninguno devolverá una lista vacía, no null
	 */
	Iterable<Usuario> listar();
	
	/**
	 * A partir de un id devuelve el usuario
	 * @param id id del usuario
	 * @return usuario encontrado o null si no lo encuentra
	 */
	Usuario buscarPorId(Long id);
	/**
	 * A partir de un email devuelve el usuario
	 * @param email email del usuario
	 * @return usuario encontrado o null si no lo encuentra
	 */
	Usuario buscarPorEmail(String email);
	
	/**
	 * Añade un nuevo usuario
	 * @param usuario usuario a añadir
	 * @return usuario añadido incluyendo el id autogenerado
	 */
	Usuario insertar(Usuario usuario);
	/**
	 * Sustituye los datos del usuario por los proporcionados, eligiendo el que hay que sustituir por el id proporcionado en el propio usuario
	 * @param usuario usuario que va a sustituir el anterior
	 * @return usuario proporcionado
	 */
	Usuario modificar(Usuario usuario);
	/**
	 * Borrar un usuario según su id
	 * @param id id del usuario a borrar
	 */
	void borrar(Long id);
}

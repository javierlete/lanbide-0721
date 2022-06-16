package com.ipartek.formacion.lombok.dal;

import java.util.function.*;

import com.ipartek.formacion.lombok.entidades.*;

import jakarta.persistence.*;

public class DaoUsuarioJpa implements DaoUsuario {

	private static final EntityManagerFactory FABRICA = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.lombok.entidades");

	private static EntityManager abrir() {
		EntityManager em = FABRICA.createEntityManager();
		em.getTransaction().begin();
		return em;
	}

	private static void cerrar(EntityManager em) {
		em.getTransaction().commit();
		em.close();
	}

	private static Object ejecutar(Function<EntityManager, Object> funcion) {
		EntityManager em = abrir();
		
		Object objeto = funcion.apply(em);
		
		cerrar(em);

		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Usuario> obtenerTodos() {
//		EntityManager em = abrir();
//
//		List<Usuario> usuarios = em.createQuery("from Usuario", Usuario.class).getResultList();
//
//		cerrar(em);
//
//		return usuarios;
		
		return (Iterable<Usuario>) ejecutar(em -> em.createQuery("from Usuario", Usuario.class).getResultList());
	}

	@Override
	public Usuario obtenerPorId(Long id) {
//		EntityManager em = abrir();
//
//		Usuario usuario = em.find(Usuario.class, id);
//
//		cerrar(em);
//
//		return usuario;
		
		return (Usuario) ejecutar(em -> em.find(Usuario.class, id));
	}

	@Override
	public Usuario insertar(Usuario usuario) {
//		EntityManager em = abrir();
//
//		em.persist(usuario);
//
//		cerrar(em);
//
//		return usuario;
		
		return (Usuario) ejecutar(em -> {
			usuario.setId(null);
			em.persist(usuario);
			return usuario;
		});
	}

	@Override
	public Usuario modificar(Usuario usuario) {
//		EntityManager em = abrir();
//
//		em.merge(usuario);
//
//		cerrar(em);
//
//		return usuario;
		
		return (Usuario) ejecutar(em -> {
			em.merge(usuario);
			return usuario;
		});
	}

	@Override
	public void borrar(Long id) {
//		EntityManager em = abrir();
//		
//		em.remove(em.find(Usuario.class, id));
//		
//		cerrar(em);
		
		ejecutar(em -> {
			em.remove(em.find(Usuario.class, id));
			return null;
		});
	}

}

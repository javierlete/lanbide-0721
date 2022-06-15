package com.ipartek.formacion.lombok;

import java.util.*;

import jakarta.persistence.*;

public class JpaPrueba {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("com.ipartek.formacion.lombok");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		// INSERT
		entityManager.persist(new Usuario(null, "@1", "1"));
		
		Usuario usuario = new Usuario(null, "@2", "2");

		System.out.println(usuario);
		
		entityManager.persist(usuario);
		
		System.out.println(usuario);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// SELECT
		List<Usuario> result = entityManager.createQuery("from Usuario", Usuario.class).getResultList();
		
		for (Usuario u : result) {
			System.out.println(u);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// MODIFICAR con objeto nuevo
		usuario = new Usuario(1L, "Javier@asdf", "laksjdlf");

		entityManager.merge(usuario);
				
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// MODIFICAR elemento recibido de JPA
		usuario = entityManager.find(Usuario.class, 2L);
		usuario.setEmail("Modificado@asdf");
				
		entityManager.getTransaction().commit();
		entityManager.close();

		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// SELECT POR ID
		usuario = entityManager.find(Usuario.class, 2L);
		
		System.out.println(usuario);
		
		usuario = entityManager.find(Usuario.class, 1L);
		
		System.out.println(usuario);
				
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// BORRAR
		entityManager.remove(entityManager.find(Usuario.class, 2L));
				
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManagerFactory.close();
	}
}

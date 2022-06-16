package com.ipartek.formacion.lombok;

import java.util.*;

import com.ipartek.formacion.lombok.entidades.*;

import jakarta.persistence.*;

public class JpaPrueba {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("com.ipartek.formacion.lombok.entidades");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		// INSERT
		Rol admin = new Rol(null, "ADMIN", "Administrador");
		Rol user = new Rol(null, "USER", "Usuario");
		
		entityManager.persist(admin);
		entityManager.persist(user);
		
		entityManager.persist(new Usuario(null, "@1", "1", admin));
		
		Usuario usuario = new Usuario(null, "@2", "2", user);

		System.out.println(usuario);
		
		entityManager.persist(usuario);
		
		System.out.println(usuario);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		// SELECT
		System.out.println("JPQL");
		List<Usuario> result = entityManager.createQuery("select u from Usuario u join fetch u.rol", Usuario.class).getResultList();
		
		System.out.println("FOR");
		
		for (Usuario u : result) {
			System.out.println(u);
			System.out.println(u.getRol());
		}
		
		System.out.println("JPQL_ROL");
		List<Rol> roles = entityManager.createQuery("from Rol", Rol.class).getResultList();
		
		System.out.println("FOR_ROL");
		
		for (Rol r : roles) {
			System.out.println(r);
			
			for (Usuario u: r.getUsuarios()) {
				System.out.println(u);
			}
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

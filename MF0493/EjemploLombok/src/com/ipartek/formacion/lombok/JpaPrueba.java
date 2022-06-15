package com.ipartek.formacion.lombok;

import java.util.*;

import jakarta.persistence.*;

public class JpaPrueba {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("com.ipartek.formacion.lombok");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(new Usuario(null, "@1", "1"));
		entityManager.persist(new Usuario(null, "@2", "2"));
		
		entityManager.getTransaction().commit();
		entityManager.close();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Usuario> result = entityManager.createQuery("from Usuario", Usuario.class).getResultList();
		
		for (Usuario usuario : result) {
			System.out.println(usuario);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();

		entityManagerFactory.close();
	}
}

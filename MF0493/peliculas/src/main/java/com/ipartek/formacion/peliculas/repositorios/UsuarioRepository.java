package com.ipartek.formacion.peliculas.repositorios;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.rest.core.annotation.*;

import com.ipartek.formacion.peliculas.entidades.*;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	Usuario findByEmailAndPassword(String email, String password);
	Iterable<Usuario> findByRol(String rol);
	
	@Query("select u from Usuario u where email = ?1 and rol = 'ADMIN'")
	Usuario buscarAdminPorEmail(String email);
}

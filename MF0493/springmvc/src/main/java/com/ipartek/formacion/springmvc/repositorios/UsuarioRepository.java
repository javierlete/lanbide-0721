package com.ipartek.formacion.springmvc.repositorios;

import org.springframework.data.repository.*;

import com.ipartek.formacion.springmvc.entidades.*;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	// http://localhost:8080/api/usuarios/search/findByEmail?email=javier@lete.net
	Usuario findByEmail(String email);
	// http://localhost:8080/api/usuarios/search/existsByEmail?email=javier@lete.net
	boolean existsByEmail(String email);
	// http://localhost:8080/api/usuarios/search/findByRol?rol=ROLE_ADMIN
	Iterable<Usuario> findByRol(String rol);
}

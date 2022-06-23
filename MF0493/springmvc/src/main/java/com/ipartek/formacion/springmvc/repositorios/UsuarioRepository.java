package com.ipartek.formacion.springmvc.repositorios;

import org.springframework.data.repository.*;

import com.ipartek.formacion.springmvc.entidades.*;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	boolean existsByEmail(String email);
}

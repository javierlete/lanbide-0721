package com.ipartek.formacion.springmvc.configuraciones;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.*;

import com.ipartek.formacion.springmvc.entidades.*;
import com.ipartek.formacion.springmvc.repositorios.*;

public class UsuarioDetailsManager implements UserDetailsManager {
	private UsuarioRepository repo;
	
	public UsuarioDetailsManager(UsuarioRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByEmail(username);

		return new UsuarioDetails(usuario);
	}

	@Override
	public boolean userExists(String username) {
		return repo.existsByEmail(username);
	}

	@Override
	public void updateUser(UserDetails user) {
		Usuario usuario = repo.findByEmail(user.getUsername());

		usuario.setEmail(user.getUsername());
		usuario.setPassword(user.getPassword());

		repo.save(usuario);
	}

	@Override
	public void deleteUser(String username) {
		repo.delete(repo.findByEmail(username));
	}

	@Override
	public void createUser(UserDetails user) {
		Usuario usuario = new Usuario();

		usuario.setEmail(user.getUsername());
		usuario.setPassword(user.getPassword());
		usuario.setRol(user.getAuthorities().stream().findFirst().orElse(null).getAuthority());

		repo.save(usuario);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}
}

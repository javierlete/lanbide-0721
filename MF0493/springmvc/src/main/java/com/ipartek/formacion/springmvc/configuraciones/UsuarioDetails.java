package com.ipartek.formacion.springmvc.configuraciones;

import java.util.*;

import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import com.ipartek.formacion.springmvc.entidades.*;

public class UsuarioDetails implements UserDetails {
	private static final long serialVersionUID = -1707666610881216757L;

	private Usuario usuario;
	
	public UsuarioDetails(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> al = new ArrayList<GrantedAuthority>();
		al.add(new GrantedAuthority() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return usuario.getRol();
			}
		});

		return al;
	}
}

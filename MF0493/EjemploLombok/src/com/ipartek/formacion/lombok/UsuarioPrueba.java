package com.ipartek.formacion.lombok;

import com.ipartek.formacion.lombok.entidades.*;

public class UsuarioPrueba {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		
		System.out.println(usuario);
		
		usuario.setPassword("Lalaralalaaaa");
		usuario.setEmail("Javier@adsf");
		
		System.out.println(usuario);
	}
}

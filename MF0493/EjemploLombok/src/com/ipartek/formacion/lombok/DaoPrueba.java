package com.ipartek.formacion.lombok;

import com.ipartek.formacion.lombok.dal.*;
import com.ipartek.formacion.lombok.entidades.*;

public class DaoPrueba {
	public static void main(String[] args) {
		DaoUsuario dao = new DaoUsuarioJpa();
		
		dao.insertar(new Usuario(1L, "asdf@asdf", "kashdg"));
		dao.insertar(new Usuario(2L, "ñalskdhgñ@asdf", "kasasahdg"));
		dao.insertar(new Usuario(3L, "qwetqwet@asdf", "kashdfghdfgdg"));
		
		for(Usuario u: dao.obtenerTodos()) {
			System.out.println(u);
		}
		
		dao.modificar(new Usuario(2L, "Cambiado", "aksdjf"));
		
		System.out.println(dao.obtenerPorId(2L));
		
		dao.borrar(3L);
		
		for(Usuario u: dao.obtenerTodos()) {
			System.out.println(u);
		}
	}
}

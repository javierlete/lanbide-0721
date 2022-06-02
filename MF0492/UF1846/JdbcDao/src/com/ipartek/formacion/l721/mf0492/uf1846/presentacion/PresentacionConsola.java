package com.ipartek.formacion.l721.mf0492.uf1846.presentacion;

import com.ipartek.formacion.l721.mf0492.uf1846.dal.*;
import com.ipartek.formacion.l721.mf0492.uf1846.entidades.*;

public class PresentacionConsola {

	public static void main(String[] args) {
		DaoUsuario dao = DaoUsuarioMySql.getInstancia();
		
		//dao.modificar(new Usuario(8L, "Email8", "Clave8"));
		
		for(Usuario u: dao.obtenerTodos()) {
			System.out.println(u);
		}
			
		//dao.insertar(new Usuario(null, "NUEVO12", "SUPERNUEVO"));
		
		Usuario usuario = dao.obtenerPorId(3L);
		
		System.out.println(usuario);
		System.out.println(usuario.getRol().getNombre());
		
		// dao.borrar(12L);
	}
}

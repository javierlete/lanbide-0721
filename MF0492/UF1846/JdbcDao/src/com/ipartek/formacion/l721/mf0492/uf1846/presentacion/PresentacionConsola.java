package com.ipartek.formacion.l721.mf0492.uf1846.presentacion;

import com.ipartek.formacion.l721.mf0492.uf1846.dal.*;
import com.ipartek.formacion.l721.mf0492.uf1846.entidades.*;

public class PresentacionConsola {

	public static void main(String[] args) {
		DaoUsuario dao = DaoUsuarioMySql.getInstancia();
		
		dao.modificar(new Usuario(8L, "Email8", "Clave8"));
		
		for(Usuario u: dao.obtenerTodos()) {
			System.out.println(u);
		}
	}
}

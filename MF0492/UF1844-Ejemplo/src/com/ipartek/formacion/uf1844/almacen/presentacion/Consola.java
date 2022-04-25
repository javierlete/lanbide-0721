package com.ipartek.formacion.uf1844.almacen.presentacion;

import com.ipartek.formacion.uf1844.almacen.accesodatos.*;
import com.ipartek.formacion.uf1844.almacen.pojos.*;

import static com.ipartek.formacion.uf1844.almacen.bibliotecas.Consola.*;

public class Consola {

	private static final DaoOrdenador dao = DaoOrdenadorMemoria.getInstancia();
	
	public static void main(String[] args) {
		mostrarId(2L);
		mostrarTodos();
	}

	private static void mostrarId(long id) {
		pl(dao.obtenerPorId(id));
		pl();
	}

	private static void mostrarTodos() {
		for(Ordenador ordenador: dao.obtenerTodos()) {
			pl(ordenador);
		}
		
		pl();
	}

}

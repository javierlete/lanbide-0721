package com.ipartek.formacion.uf1844.almacen.presentacion;

import static com.ipartek.formacion.uf1844.almacen.bibliotecas.Consola.*;

import java.math.*;
import java.time.*;

import com.ipartek.formacion.uf1844.almacen.accesodatos.*;
import com.ipartek.formacion.uf1844.almacen.pojos.*;

public class Consola {

	private static final DaoOrdenador dao = DaoOrdenadorMemoria.getInstancia();
	
	public static void main(String[] args) {
		mostrarId(2L);
		mostrarTodos();
		
		dao.insertar(new Ordenador(null, "Lenovo", "Thinkpad", LocalDate.now(), new BigDecimal("700")));
		
		mostrarTodos();
		
		Ordenador ordenador = dao.obtenerPorId(1L);
		ordenador.setPrecio(new BigDecimal("2000"));
		
		dao.modificar(ordenador);
		
		mostrarTodos();
		
		dao.borrar(3L);
		
		mostrarTodos();
		
		for(Ordenador o: dao.buscarPorMarca("e")) {
			pl(o);
		}
		
		for(Ordenador o: dao.buscarPorPrecio(new BigDecimal("800"), new BigDecimal("1200"))) {
			pl(o);
		}
		
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

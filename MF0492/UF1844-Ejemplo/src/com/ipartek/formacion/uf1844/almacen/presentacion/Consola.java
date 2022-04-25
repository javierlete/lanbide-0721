package com.ipartek.formacion.uf1844.almacen.presentacion;

import static com.ipartek.formacion.uf1844.almacen.bibliotecas.Consola.*;

import com.ipartek.formacion.uf1844.almacen.accesodatos.*;
import com.ipartek.formacion.uf1844.almacen.pojos.*;

public class Consola {

	private static final DaoOrdenador dao = DaoOrdenadorMemoria.getInstancia();

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();

			opcion = leerInt("Introduce la opción deseada");

			procesarOpcion(opcion);
		} while (opcion != 0);

//		mostrarId(2L);
//		mostrarTodos();
//		
//		dao.insertar(new Ordenador(null, "Lenovo", "Thinkpad", LocalDate.now(), new BigDecimal("700")));
//		
//		mostrarTodos();
//		
//		Ordenador ordenador = dao.obtenerPorId(1L);
//		ordenador.setPrecio(new BigDecimal("2000"));
//		
//		dao.modificar(ordenador);
//		
//		mostrarTodos();
//		
//		dao.borrar(3L);
//		
//		mostrarTodos();
//		
//		for(Ordenador o: dao.buscarPorMarca("e")) {
//			pl(o);
//		}
//		
//		for(Ordenador o: dao.buscarPorPrecio(new BigDecimal("800"), new BigDecimal("1200"))) {
//			pl(o);
//		}
//		
	}

	private static void mostrarMenu() {
		pl("1. Listar");
		pl("2. Buscar Por Id");
		pl("3. Insertar");
		pl("4. Modificar");
		pl("5. Borrar");
		pl("6. Buscar por marca");
		pl("7. Buscar por precio");
		pl("0. Salir");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 0:
			pl("Gracias por usar este programa");
			break;
		case 1:
			mostrarTodos();
			break;
		case 2:
			buscarPorId();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 6:
			buscarPorMarca();
			break;
		case 7:
			buscarPorPrecio();
			break;
		default:
			ple("No se reconoce dicha opción");
		}
	}

	private static void buscarPorPrecio() {
		// TODO Auto-generated method stub
		
	}

	private static void buscarPorId() {
		// TODO Auto-generated method stub
		
	}

	private static void insertar() {
		// TODO Auto-generated method stub
		
	}

	private static void modificar() {
		// TODO Auto-generated method stub
		
	}

	private static void borrar() {
		// TODO Auto-generated method stub
		
	}

	private static void buscarPorMarca() {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarId(long id) {
		pl(dao.obtenerPorId(id));
		pl();
	}

	private static void mostrarTodos() {
		for (Ordenador ordenador : dao.obtenerTodos()) {
			pl(ordenador);
		}

		pl();
	}

}

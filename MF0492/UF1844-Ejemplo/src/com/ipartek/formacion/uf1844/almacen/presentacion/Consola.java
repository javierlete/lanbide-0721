package com.ipartek.formacion.uf1844.almacen.presentacion;

import static com.ipartek.formacion.uf1844.almacen.bibliotecas.Consola.*;

import java.math.*;

import com.ipartek.formacion.uf1844.almacen.accesodatos.*;
import com.ipartek.formacion.uf1844.almacen.pojos.*;

public class Consola {

	private static final boolean CON_ID = true;
	private static final boolean SIN_ID = false;
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

	private static void buscarPorId() {
		Long id = leerLong("Dime el id a buscar");

		mostrarId(id);
	}

	private static void insertar() {
		Ordenador ordenador = consola2Ordenador(SIN_ID);

		dao.insertar(ordenador);
	}

	private static void modificar() {
		Ordenador ordenador = consola2Ordenador(CON_ID);

		dao.modificar(ordenador);
	}

	private static Ordenador consola2Ordenador(boolean conId) {
		Ordenador ordenador = new Ordenador();

		if (conId) {
			ordenador.setId(leerLong("Id"));
		}

		ordenador.setMarca(leerString("Marca"));

		boolean correcto = false;

		do {
			try {
				ordenador.setModelo(leerString("Modelo"));
				correcto = true;
			} catch (Exception e) {
				ple(e.getMessage());
			}
		} while (!correcto);

		correcto = false;

		do {
			try {
				ordenador.setFechaFabricacion(leerLocalDate("Fecha de fabricación"));
				correcto = true;
			} catch (Exception e) {
				ple(e.getMessage());
			}
		} while (!correcto);

		correcto = false;

		do {
			try {
				ordenador.setPrecio(leerBigDecimal("Precio"));
				correcto = true;
			} catch (Exception e) {
				ple(e.getMessage());
			}
		} while (!correcto);
		
		return ordenador;
	}

	private static void borrar() {
		Long id = leerLong("Dime el id a borrar");

		dao.borrar(id);
	}

	private static void buscarPorMarca() {
		String marca = leerString("Texto a buscar en la marca");

		mostrarTodos(dao.buscarPorMarca(marca));
	}

	private static void buscarPorPrecio() {
		BigDecimal minimo = leerBigDecimal("Mínimo");
		BigDecimal máximo = leerBigDecimal("Máximo");

		mostrarTodos(dao.buscarPorPrecio(minimo, máximo));
	}

	private static void mostrarId(long id) {
		Ordenador ordenador = dao.obtenerPorId(id);

		if (ordenador != null) {
			pl(ordenador);
		} else {
			pl("No se ha encontrado el ordenador con ese id");
		}
	}

	private static void mostrarTodos() {
		for (Ordenador ordenador : dao.obtenerTodos()) {
			pl(ordenador);
		}

		pl();
	}

	private static void mostrarTodos(Iterable<Ordenador> ordenadores) {
		for (Ordenador ordenador : ordenadores) {
			pl(ordenador);
		}

		pl();
	}

}

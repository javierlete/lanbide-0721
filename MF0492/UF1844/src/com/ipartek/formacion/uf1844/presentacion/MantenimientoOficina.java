package com.ipartek.formacion.uf1844.presentacion;

import static com.ipartek.formacion.uf1844.bibliotecas.Consola.*;

import com.ipartek.formacion.uf1844.poo.pojos.*;

public class MantenimientoOficina {
	private static final Oficina oficina = new Oficina("Bilbao");

	static {
		oficina.agregar(new Persona());
		oficina.agregar(new Persona(2L, "Javier"));
		oficina.agregar(new Empleado(3L, "Pepe", "1234123412341234"));
	}

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();

			opcion = leerInt("Elige una opción");

			procesarOpcion(opcion);
		} while (opcion != 0);
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 0:
			pl("Gracias por usar este programa");
			break;
		case 1:
			listado();
			break;
		case 2:
			agregar();
			break;
		case 3:
			modificar();
			break;
		case 4:
			borrar();
			break;
		default:
			ple("No existe dicha opción");
		}
	}

	private static void listado() {
		pl("LISTADO");

		for (Persona p : oficina.getPersonas()) {
			mostrarPersona(p);
		}
	}

	private static void mostrarPersona(Persona p) {
		pl(p);
	}

	private static void agregar() {
		pl("AÑADIR");

		Persona persona = new Persona();

		pedirId(persona);
		pedirNombre(persona);
		pedirFechaNacimiento(persona);

		oficina.agregar(persona);

		mostrarPersona(persona);
	}

	private static void pedirId(Persona persona) {
		persona.setId(leerLong("Id"));
	}

	private static void pedirNombre(Persona persona) {
		do {
			try {
				persona.setNombre(leerString("Nombre"));
				break;
			} catch (PojosException e) {
				ple(e.getMessage());
			}
		} while (true);
	}

	private static void pedirFechaNacimiento(Persona persona) {
		do {
			try {
				persona.setFechaNacimiento(leerLocalDate("Fecha de nacimiento"));
				break;
			} catch (PojosException e) {
				ple(e.getMessage());
			}
		} while (true);
	}

	private static void modificar() {
		pl("MODIFICAR");
		
		long id = leerLong("Id");
		Persona persona = oficina.getPersona(id);
		
		if(persona == null) {
			ple("No se ha encontrado una persona");
			return;
		}
		
		mostrarPersona(persona);
		
		pedirNombre(persona);
		pedirFechaNacimiento(persona);
	}

	private static void borrar() {
		pl("BORRAR");
		
		long id = leerLong("Id");
		oficina.borrarPersona(id);
	}

	private static void mostrarMenu() {
		pl("Menú");
		pl("----");
		pl("1. Listado");
		pl("2. Añadir");
		pl("3. Modificar");
		pl("4. Borrar");
		pl("0. Salir");
	}
}

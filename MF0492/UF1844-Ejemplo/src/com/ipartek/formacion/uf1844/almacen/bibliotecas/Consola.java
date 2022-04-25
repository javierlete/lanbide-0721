package com.ipartek.formacion.uf1844.almacen.bibliotecas;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Consola {
	private static final Scanner sc = new Scanner(System.in);
	private static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static void pl() {
		System.out.println();
	}
	
	public static void pl(Object o) {
		System.out.println(o);
	}

	public static void p(Object o) {
		System.out.print(o);
	}

	public static void ple(Object o) {
		System.err.println(o);
	}
	
	public static int leerInt(String mensaje) {
		do {
			try {
				return Integer.parseInt(leerString(mensaje));
			} catch (NumberFormatException e) {
				ple("No es un entero, por favor introducelo de nuevo");
			} 
		} while (true);
	}
	
	public static long leerLong(String mensaje) {
		do {
			try {
				return Long.parseLong(leerString(mensaje));
			} catch (NumberFormatException e) {
				ple("No es un Long, por favor introducelo de nuevo");
			}
		} while (true);
	}

	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return sc.nextLine();
	}

	public static LocalDate leerLocalDate(String mensaje) {
		do {
			try {
				String texto = leerString(mensaje + " (AAAA-MM-DD) ");
				return LocalDate.parse(texto, formatoFecha);
			} catch (DateTimeParseException e) {
				ple("No es una fecha");
			}
		} while (true);
	}
}

package com.ipartek.formacion.uf1844;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase de ejemplo para ver la sintaxis básica de Java
 * 
 * @author javierlete
 *
 */
public class Sintaxis {
	public static void main(String[] args) {
		// Java5
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime tu nombre: ");
		
		String nombre = sc.nextLine();
		
		System.out.println("Hola " + nombre);
		
		sc.close();
	}
	
	/**
	 * Sentencias de control
	 * 
	 * @param args
	 */
	public static void mainSentencias(String[] args) {
		String opcion = "abrir";

		// Java7
		switch (opcion) {
		case "abrir":
			System.out.println("Abriendo");
			break;
		case "cerrar":
			System.out.println("Cerrando");
			break;
		default:
			System.out.println("Lo que te de la gana");
		}
		
		// Java 1.0
		String[] textos = { "Uno", "Dos", "Tres" };
		
		for(int i = 0; i < textos.length; i++) {
			System.out.println(textos[i]);
		}
		
		// Java5 "foreach" -> Iterable (ArrayList, HashMap, Arrays...)
		for(String texto: textos) {
			System.out.println(texto);
		}
	}

	/**
	 * Excepciones
	 * 
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void mainExcepciones(String[] args) {
		int div, a = 5, b = 2;

		try {
			System.out.println("ANTES");

			int[] arr = new int[2];

			arr[5] = 10;

			String s = null;

			s.toUpperCase();

			div = a / b;

			System.out.println(div);
		} catch (ArithmeticException e) {
			System.out.println("No se puede hacer una división por cero");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Te has salido de la lista");
		} finally {
			System.out.println("Me ejecuto SIEMPRE");
		}

		System.out.println("DESPUES");
	}

	/**
	 * Operadores
	 * 
	 * @param args
	 */
	public static void mainOperadores(String[] args) {
		// Aritméticos
		// +, -, *, /
		// %

		int r = 5 % 2;
		System.out.println(r);

		// 5 XOR 2 => 101 XOR 010 = 111 => 7
		System.out.println(5 ^ 2);
		System.out.println(Math.pow(5, 2));

		// Comparaciones
		// <, >, <=, >=, ==, !=
		// System.out.println(5 == "5");

		int x = 5;
		// boolean resultado = 0 <= x <= 10;

		// Lógicos
		// &, &&, |, ||, !
		boolean resultado = 0 <= x && x <= 10;

		System.out.println(resultado);

		// +=, *=, /=, ... =

		// x = x + 2;
		x += 2;

		int y, z;

		System.out.println(x = y = z = 4);

		System.out.println(y);
		System.out.println(z);

		// ++, --
		System.out.println(x++);
		System.out.println(++y);

		// ? :
		System.out.println(resultado);
		System.out.println(resultado ? "OK" : "KO");
	}

	/**
	 * Conversiones
	 * 
	 * @param args
	 */
	public static void mainConversiones(String[] args) {
		// Texto a primitivo
		String s = "5";

		int i = Integer.parseInt(s);

		System.out.println(i == 5);

		s = "c";

		char c = s.charAt(0);

		System.out.println(c);

		s = "false";

		boolean b = s.equals("true");

		System.out.println(b);

		// Primitivo a texto
		s = String.valueOf(i);

		StringBuffer sb = new StringBuffer();

		// Cualquier objeto a texto
		// s = String.valueOf(sb);
		s = sb.toString();
	}

	/**
	 * Fechas
	 * 
	 * @param args
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	public static void mainFechas(String[] args) throws ParseException {
		// 1.0
		Date d = new Date();

		System.out.println(d);
		System.out.println((d.getYear() + 1900) + "-" + (d.getMonth() + 1) + "-" + d.getDate());

		// 1.1
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));

		String texto = "2014-12-31 12:34:56";
		System.out.println(sdf.parse(texto));

		Calendar c = new GregorianCalendar();

		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c);
		System.out.println(sdf.format(c.getTime()));

		// Java5 JodaTime

		// Java8 java.time JSR-310
		LocalDateTime ldt = LocalDateTime.now();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.format(dtf));

		ldt = LocalDateTime.parse(texto, dtf);
		System.out.println(ldt);
	}

	/**
	 * Método que se utiliza por defecto para arrancar la aplicación
	 * 
	 * TIPOS DE DATOS
	 * 
	 * @param args argumentos pasados a la aplicación por <b>consola</b>
	 */
	public static void mainTipos(String[] args) {
		// Muestra el texto hola por consola
		System.out.println("Hola");

		/*
		 * Tipos de datos Enteros, coma flotante, caracter y booleanos
		 */

		int a;

		a = 5;

		System.out.println(a);

		double d1 = 2.0 / 3.0; // 0.666666666666666;
		double d2 = -0.666666666666667;

		double d = d1 + d2;

		System.out.println(d);

		long l = 123123123123L;

		System.out.println(l);

		char c = 'g';

		System.out.println(c);

		boolean b = true;

		System.out.println(b);

		Integer i = null;

		System.out.println(i);

		BigDecimal bd1 = new BigDecimal("0.666666666666666");
		BigDecimal bd2 = new BigDecimal("-0.666666666666667");

		BigDecimal bd = bd1.add(bd2);

		System.out.println(bd);

		String nombre;

		nombre = null;

		nombre = "Javier";

		System.out.println("Hola " + nombre);

		System.out.println(nombre.length());

		System.out.println(nombre.substring(0, 4).toUpperCase());

		int x = 5, y = 5;

		System.out.println(x == y);

		String nombre1 = new String("Javier");
		String nombre2 = new String("Javier");

		// Comparación de si son EL MISMO OBJETO
		System.out.println(nombre1 == nombre2);

		// Comparación de si tienen el mismo CONTENIDO
		System.out.println(nombre1.equals(nombre2));

		String log = "";

		log += "Un texto\n";

		log += "Valor " + x + " " + y + "\n";

//		log = new StringBuffer(log).append("Valor ").append(x)
//				.append(" ").append(y).append("\n").toString();

		System.out.println(log);

		StringBuffer logB = new StringBuffer();

		logB.append("Un texto\n");

		logB.append("Valor ").append(x).append(" ").append(y).append("\n");

		System.out.println(logB); // .toString());

		int[] arr = { 5, 3, 1 }; // new int[3];

//		arr[0] = 5;
//		arr[1] = 3;
//		arr[2] = 1;

		System.out.println(arr[0]);

		System.out.println(arr.length);

		char[][] tablero = new char[3][4];

		tablero[0][0] = 'T';
		tablero[1][0] = 'P';

		System.out.println(tablero.length);
		System.out.println(tablero[0].length);

		ArrayList<Integer> al = new ArrayList<>();

		al.add(6);
		al.add(7);
		al.add(8);

		System.out.println(al.size());

		System.out.println(al.get(0));

		HashMap<String, Integer> dic = new HashMap<>();

		dic.put("Uno", 1);
		dic.put("Dos", 2);
		dic.put("Tres", 3);

		System.out.println(dic.get("Dos"));
	}
}

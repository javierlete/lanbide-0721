package com.ipartek.formacion.uf1844;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase de ejemplo para ver la sintaxis
 * básica de Java
 * 
 * @author javierlete
 *
 */
public class Sintaxis {

	/**
	 * Método que se utiliza por defecto
	 * para arrancar la aplicación
	 * 
	 * @param args argumentos pasados a 
	 * la aplicación por <b>consola</b>
	 */
	public static void main(String[] args) {
		// Muestra el texto hola por consola
		System.out.println("Hola");
		
		/*
		 * Tipos de datos
		 * Enteros, coma flotante, caracter y booleanos
		 */
		
		int a;
		
		a = 5;
		
		System.out.println(a);
		
		double d1 = 2.0/3.0; // 0.666666666666666;
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
		
		System.out.println(nombre.substring(0, 4).toUpperCase());
		
		int x = 5, y = 5;
		
		System.out.println(x == y);
		
		String nombre1 = new String("Javier");
		String nombre2 = new String("Javier");
		
		System.out.println(nombre1 == nombre2);
		
		System.out.println(nombre1.equals(nombre2));
		
		String log = "";
		
		log += "Un texto\n";
		
		log += "Valor " + x + " " + y + "\n";
		
//		log = new StringBuffer(log).append("Valor ").append(x)
//				.append(" ").append(y).append("\n").toString();
		
		System.out.println(log);
		
		StringBuffer logB = new StringBuffer();
		
		logB.append("Un texto\n");
		
		logB.append("Valor ").append(x)
		.append(" ").append(y).append("\n");
		
		System.out.println(logB);
		
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








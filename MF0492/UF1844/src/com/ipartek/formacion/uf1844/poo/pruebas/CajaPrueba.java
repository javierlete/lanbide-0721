package com.ipartek.formacion.uf1844.poo.pruebas;

import com.ipartek.formacion.uf1844.poo.pojos.Caja;

public class CajaPrueba {
	public static void main(String[] args) {
		Caja<Integer> c = new Caja<>(5);
		
		System.out.println(c);
		
		// c = new Caja<String>("Hola");
		
		Caja<String> c2 = new Caja<>("Hola");
		
		System.out.println(c2);
	}
}

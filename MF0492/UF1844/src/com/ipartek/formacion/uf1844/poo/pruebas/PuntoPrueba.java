package com.ipartek.formacion.uf1844.poo.pruebas;

import com.ipartek.formacion.uf1844.poo.pojos.Punto;

public class PuntoPrueba {
	public static void main(String[] args) {
		Punto p = new Punto(1L, 5.5, 6.6);
		
		System.out.println(p);
		
		System.out.println("El punto origen es: " + Punto.ORIGEN);
	}
}

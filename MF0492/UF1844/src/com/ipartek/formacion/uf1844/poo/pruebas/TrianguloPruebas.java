package com.ipartek.formacion.uf1844.poo.pruebas;

import com.ipartek.formacion.uf1844.poo.pojos.Punto;
import com.ipartek.formacion.uf1844.poo.pojos.PuntoNombre;
import com.ipartek.formacion.uf1844.poo.pojos.Triangulo;

public class TrianguloPruebas {
	public static void main(String[] args) {
		Punto p = new Punto(2L, 2.1, 3.2);
		
		Triangulo t = new Triangulo(
				1L,
				new Punto(1L, 1.1, 2.2),
				p,
				new PuntoNombre(3L, 3.1, 4.2, "Bilbao")
				);
				
		System.out.println(t);
	}
}

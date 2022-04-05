package com.ipartek.formacion.uf1844.poo.pruebas;

import com.ipartek.formacion.uf1844.poo.pojos.Empleado;
import com.ipartek.formacion.uf1844.poo.pojos.Persona;

public class EmpleadoPrueba {
	public static void main(String[] args) {
		Empleado e = new Empleado(5L, "Pepe", "4321432143214321");

		System.out.println(e.aTexto());

		e.setNombre("Javier");
		e.setNumeroSeguridadSocial("1234123412341234");

		System.out.println(e.aTexto());

		Persona p = e;

		System.out.println("PERSONA");
		System.out.println(p.aTexto());
		
		System.out.println(p.getNombre());

		if (p instanceof Empleado) {
			Empleado e2 = (Empleado) p;

			System.out.println(e2.getNumeroSeguridadSocial());
		} else {
			System.out.println("No es un empleado");
		}

		Persona p2 = new Persona();

		if (p2 instanceof Empleado) {

			Empleado e3 = (Empleado) p2;

			System.out.println(e3.getNumeroSeguridadSocial());
		} else {
			System.out.println("No es un empleado");
		}
		
		Object o = new Object();
		
		System.out.println(o.equals(o));
		
		Persona per1 = new Persona();
		Persona per2 = new Persona();
		
		System.out.println(per1 == per2);
		System.out.println(per1.equals(per2));
		
		System.out.println(per1);
		
		System.out.println(e);
	}
}








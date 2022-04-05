package com.ipartek.formacion.uf1844.poo.pruebas;

import com.ipartek.formacion.uf1844.poo.pojos.Oficina;
import com.ipartek.formacion.uf1844.poo.pojos.Persona;

public class OficinaPrueba {
	public static void main(String[] args) {
		Oficina o = new Oficina("Bilbao");
		
		o.agregar(new Persona());
		o.agregar(null);
		o.agregar(new Persona(2L, "Javier"));
		
		for(Persona persona: o.getPersonas()) {
			System.out.println(persona.aTexto());
		}
	}
}

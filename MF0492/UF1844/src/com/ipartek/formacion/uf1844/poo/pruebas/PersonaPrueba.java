package com.ipartek.formacion.uf1844.poo.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.uf1844.poo.pojos.Persona;

public class PersonaPrueba {
	// PersonaPrueba.main(new String[] { "uno", "dos" })
	public static void main(String[] args) {
		Persona p = new Persona();
		
		p.setId(5L);
		p.setNombre("   Jav    ");
		p.setFechaNacimiento(LocalDate.now().minusYears(18));
		
		System.out.println(p);
		
		System.out.println(p.aTexto());
		
//		mostrarPersona(p);
		
		Persona p2 = new Persona(2L, "Pepe", LocalDate.now().minusYears(25));
		
		System.out.println(p2.aTexto());
		
//		mostrarPersona(p2);
		
		Persona p3 = new Persona(3L, "Juan");
		
		System.out.println(p3.aTexto());
		
//		mostrarPersona(p3);
		
		Persona p4 = new Persona();
		
		System.out.println(p4.aTexto());
		
//		mostrarPersona(p4);
		
		System.out.println(p4.isJubilado());
		System.out.println(p2.isJubilado());
		
		Persona p5 = new Persona(7L, "Jubi", LocalDate.of(1950, 1, 1));
		
		System.out.println(p5.aTexto());
				
		System.out.println(Persona.getEdadJubilacion());
		System.out.println(p5.isJubilado());
		
		Persona.setEdadJubilacion(80);
		
		System.out.println(Persona.getEdadJubilacion());
		System.out.println(p5.isJubilado());
	}

//	private static void mostrarPersona(Persona persona) {
//		System.out.println(persona.getId());
//		System.out.println(persona.getNombre());
//		System.out.println(persona.getFechaNacimiento());
//	}

}













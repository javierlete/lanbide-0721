package com.ipartek.formacion.uf1844.poo.pojos;
// Plain Old Java Objects

import java.time.LocalDate;

// Representa las características de una persona
public class Persona {

	// Constantes
	private static final int MAYORIA_DE_EDAD = 18;
	private static final String DESCONOCIDO = "<DESCONOCIDO>";
	private static final int MINIMO_CARACTERES_NOMBRE = 3;

	// Variable estática ("de clase")
	private static int edadJubilacion = 65;
	
	// Variables de instancia (privadas)
	private Long id;
	private String nombre;
	private LocalDate fechaNacimiento;

	// Constructores
	public Persona(Long id, String nombre, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public Persona(Long id, String nombre) {
		this(id, nombre, null);
	}
	
	public Persona() {
		this(1L, DESCONOCIDO, null);
	}

	// Getters y setters (públicos)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id == null || id <= 0L) {
			throw new RuntimeException("El ID debe ser 1 o más");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("Se debe rellenar el nombre");
		}

		/*
		 * if("".equals(nombre)) { throw new
		 * RuntimeException("Debe haber escrito algún texto"); }
		 */

		nombre = nombre.trim();

		if (nombre.length() < MINIMO_CARACTERES_NOMBRE) {
			throw new RuntimeException("El nombre debe tener al menos 3 caracteres");
		}

		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now().minusYears(MAYORIA_DE_EDAD))) {
			throw new RuntimeException("Debe ser mayor de edad");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}

	// Getters y setters estáticos ("de clase")
	public static int getEdadJubilacion() {
		return edadJubilacion;
	}
	
	public static void setEdadJubilacion(int edadJubilacion) {
		Persona.edadJubilacion = edadJubilacion;
	}
	// Métodos de instancia
	public String aTexto() {
		return id + ", " + nombre + ", " + fechaNacimiento;
	}
	
	public Boolean isJubilado() {
		if(fechaNacimiento == null) {
			return null;
		}
		
		return fechaNacimiento.plusYears(edadJubilacion).isBefore(LocalDate.now());
	}
}













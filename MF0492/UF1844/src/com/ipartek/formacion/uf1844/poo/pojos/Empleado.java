package com.ipartek.formacion.uf1844.poo.pojos;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona {

	private static final long serialVersionUID = 3091259550523849101L;
	
	private String numeroSeguridadSocial;

	public Empleado(Long id, String nombre, LocalDate fechaNacimiento, String numeroSeguridadSocial) {
		super(id, nombre, fechaNacimiento);
		setNumeroSeguridadSocial(numeroSeguridadSocial);
	}
	
	public Empleado(Long id, String nombre, String numeroSeguridadSocial) {
		this(id, nombre, Persona.FECHA_POR_DEFECTO, numeroSeguridadSocial);
	}

	public String getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}

	public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroSeguridadSocial);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(numeroSeguridadSocial, other.numeroSeguridadSocial);
	}

	@Override
	public String toString() {
		return "Empleado [numeroSeguridadSocial=" + numeroSeguridadSocial + ", " + super.toString() + "]";
	}

	@Override
	public String aTexto() {
		return super.aTexto() + ", " + numeroSeguridadSocial;
	}
	
}

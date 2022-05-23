package com.ipartek.formacion.mf0492.uf1845.ejemplo.modelos;

import java.math.*;
import java.time.*;
import java.util.*;

public class Proyecto {
	private Long id;
	private String nombre;
	private BigDecimal presupuesto;
	private LocalDate inicio;
	private LocalDate fin;

	public Proyecto(Long id, String nombre, BigDecimal presupuesto, LocalDate inicio, LocalDate fin) {
		setId(id);
		setNombre(nombre);
		setPresupuesto(presupuesto);
		setInicio(inicio);
		setFin(fin);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(BigDecimal presupuesto) {
		this.presupuesto = presupuesto;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fin, id, inicio, nombre, presupuesto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(fin, other.fin) && Objects.equals(id, other.id) && Objects.equals(inicio, other.inicio)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(presupuesto, other.presupuesto);
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", inicio=" + inicio
				+ ", fin=" + fin + "]";
	}

}

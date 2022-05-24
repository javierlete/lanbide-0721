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

	private Map<String, String> errores = new HashMap<>();

	public Proyecto(String id, String nombre, String presupuesto, String inicio, String fin) {
		setId(id);
		setNombre(nombre);
		setPresupuesto(presupuesto);
		setInicio(inicio);
		setFin(fin);
	}

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

	private void setId(String id) {
		Long idLong = null;
		
		if (id != null && id.trim().length() != 0) {
			try {
				idLong = Long.parseLong(id);
			} catch (NumberFormatException e) {
				errores.put("id", "El id debe ser numérico");
			}
		}
	
		setId(idLong);
	}

	public void setId(Long id) {
		if(id != null && id <= 0) {
			errores.put("id", "El id debe ser positivo");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() < 3) {
			errores.put("nombre", "El nombre debe tener 3 caracteres o más");
		}
		this.nombre = nombre;
	}

	public BigDecimal getPresupuesto() {
		return presupuesto;
	}

	private void setPresupuesto(String presupuesto) {
		BigDecimal presupuestoBd = null;
	
		if (presupuesto != null && presupuesto.trim().length() != 0) {
			try {
				presupuestoBd = new BigDecimal(presupuesto);
			} catch (Exception e) {
				errores.put("presupuesto", "El presupuesto debe ser una cantidad decimal");
			}
		}
	
		setPresupuesto(presupuestoBd);
	}

	public void setPresupuesto(BigDecimal presupuesto) {
		if(presupuesto != null && presupuesto.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("presupuesto", "El presupuesto debe ser 0 o superior");
		}
		this.presupuesto = presupuesto;
	}

	private void setInicio(String inicio) {
		LocalDate inicioLd = null;
	
		if (inicio != null && inicio.trim().length() != 0) {
			try {
				inicioLd = LocalDate.parse(inicio);
			} catch (Exception e) {
				errores.put("inicio", "El inicio debe ser una fecha");
			}
		}
	
		setInicio(inicioLd);
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

	private void setFin(String fin) {
		LocalDate finLd = null;
	
		if (fin != null && fin.trim().length() != 0) {
			try {
				finLd = LocalDate.parse(fin);
			} catch (Exception e) {
				errores.put("fin", "El fin debe ser una fecha");
			}
		}
	
		setFin(finLd);
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Map<String, String> getErrores() {
		return errores;
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

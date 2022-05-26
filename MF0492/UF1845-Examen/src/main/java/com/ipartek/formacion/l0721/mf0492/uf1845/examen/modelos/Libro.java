package com.ipartek.formacion.l0721.mf0492.uf1845.examen.modelos;

import java.math.*;
import java.util.*;

public class Libro {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Integer descuento;

	private Map<String, String> errores = new HashMap<>();

	public Libro(String id, String nombre, String precio, String descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}
	
	public Libro(Long id, String nombre, BigDecimal precio, Integer descuento) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescuento(descuento);
	}

	public Long getId() {
		return id;
	}

	public void setId(String id) {
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
		if (id != null && id <= 0) {
			errores.put("id", "El id debe ser positivo");
		}
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 2 || nombre.trim().length() > 150) {
			errores.put("nombre", "El nombre debe tener entre 2 y 150 caracteres");
		}
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		BigDecimal precioBd = null;

		if (precio != null && precio.trim().length() != 0) {
			if(!precio.matches("\\d+[,\\.]\\d\\d")) {
				errores.put("precio", "El precio debe ser positivo y tener dos decimales");
			}
			try {
				precioBd = new BigDecimal(precio);
			} catch (Exception e) {
				errores.put("precio", "El precio debe ser una cantidad decimal");
			}
		}

		setPrecio(precioBd);
	}

	public void setPrecio(BigDecimal precio) {
		if (precio != null && precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio debe ser 0 o superior");
		}
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		if (descuento == null || descuento.trim().length() == 0) {
			setDescuento(0);
			return;
		}

		try {
			Integer i = Integer.parseInt(descuento);
			setDescuento(i);
		} catch (NumberFormatException e) {
			errores.put("descuento", "El descuento debe ser un número");
		}
	}

	public void setDescuento(Integer descuento) {
		if (descuento == null) {
			this.descuento = 0;
			return;
		}

		if (!(0 <= descuento && descuento <= 100)) {
			errores.put("descuento", "El descuento debe ser entre 0 y 100");
		}

		this.descuento = descuento;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descuento, errores, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(descuento, other.descuento) && Objects.equals(errores, other.errores)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", errores=" + errores + "]";
	}
	
	
}

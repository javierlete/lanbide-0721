package com.ipartek.formacion.uf1845.modelos;

import java.math.*;
import java.util.*;

public class Linea {
	private Libro libro;
	private Integer cantidad;
	
	public Linea(Libro libro, Integer cantidad) {
		setLibro(libro);
		setCantidad(cantidad);
	}

	public BigDecimal getPrecio() {
		return libro.getPrecio().multiply(new BigDecimal(cantidad));
	}
	
	public BigDecimal getIva() {
		return getPrecio().multiply(Factura.IVA);
	}
	
	public BigDecimal getTotal() {
		return getPrecio().add(getIva());
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(libro, other.libro);
	}

	@Override
	public String toString() {
		return "Linea [libro=" + libro + ", cantidad=" + cantidad + "]";
	}
	
	
}

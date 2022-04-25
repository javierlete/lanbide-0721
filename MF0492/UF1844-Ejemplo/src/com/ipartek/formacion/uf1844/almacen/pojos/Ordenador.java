package com.ipartek.formacion.uf1844.almacen.pojos;

import java.math.*;
import java.time.*;
import java.util.*;

public class Ordenador {
	private Long id;
	private String marca;
	private String modelo;
	private LocalDate fechaFabricacion;
	private BigDecimal precio;
	
	public Ordenador(Long id, String marca, String modelo, LocalDate fechaFabricacion, BigDecimal precio) {
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setFechaFabricacion(fechaFabricacion);
		setPrecio(precio);
	}
	
	public Ordenador() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if(modelo.trim().length() < 2) {
			throw new PojosException("No se admiten modelos de menos de dos caracteres");
		}
		
		this.modelo = modelo;
	}
	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}
	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		if(fechaFabricacion.isBefore(LocalDate.of(1970, 1, 1))) {
			throw new PojosException("No se admiten fechas de fabricación anteriores a 1970");
		}
		
		this.fechaFabricacion = fechaFabricacion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if(precio.compareTo(BigDecimal.ZERO) < 0) {
			throw new PojosException("No se admiten precios menores que cero");
		}
		
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaFabricacion, id, marca, modelo, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordenador other = (Ordenador) obj;
		return Objects.equals(fechaFabricacion, other.fechaFabricacion) && Objects.equals(id, other.id)
				&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Ordenador [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", fechaFabricacion="
				+ fechaFabricacion + ", precio=" + precio + "]";
	}
}

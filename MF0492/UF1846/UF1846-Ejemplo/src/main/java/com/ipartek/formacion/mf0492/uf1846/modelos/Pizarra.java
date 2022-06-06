package com.ipartek.formacion.mf0492.uf1846.modelos;

import java.math.*;
import java.util.*;

public class Pizarra {
	public static enum Tipo { Velleda, Tiza, RotaFolios } 
	
	private Long id;
	private String marca;
	private int anchoEnMm, altoEnMm;
	private BigDecimal precio;
	private Tipo tipo;
	
	public Pizarra(Long id, String marca, int anchoEnMm, int altoEnMm, BigDecimal precio, Tipo tipo) {
		setId(id);
		setMarca(marca);
		setAnchoEnMm(anchoEnMm);
		setAltoEnMm(altoEnMm);
		setPrecio(precio);
		setTipo(tipo);
	}
	
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
	public int getAnchoEnMm() {
		return anchoEnMm;
	}
	public void setAnchoEnMm(int anchoEnMm) {
		this.anchoEnMm = anchoEnMm;
	}
	public int getAltoEnMm() {
		return altoEnMm;
	}
	public void setAltoEnMm(int altoEnMm) {
		this.altoEnMm = altoEnMm;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altoEnMm, anchoEnMm, id, marca, precio, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizarra other = (Pizarra) obj;
		return altoEnMm == other.altoEnMm && anchoEnMm == other.anchoEnMm && Objects.equals(id, other.id)
				&& Objects.equals(marca, other.marca) && Objects.equals(precio, other.precio) && tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "Pizarra [id=" + id + ", marca=" + marca + ", anchoEnMm=" + anchoEnMm + ", altoEnMm=" + altoEnMm
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}
}

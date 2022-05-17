package com.ipartek.formacion.uf1845.modelos;

import java.math.*;

public class Linea {
	private Libro libro;
	private Integer cantidad;
	
	public BigDecimal getPrecio() {
		return libro.getPrecio().multiply(new BigDecimal(cantidad));
	}
	
	public BigDecimal getIva() {
		return getPrecio().multiply(Factura.IVA);
	}
	
	public BigDecimal getTotal() {
		return getPrecio().add(getIva());
	}
}

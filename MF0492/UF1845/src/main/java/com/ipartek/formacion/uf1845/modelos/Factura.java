package com.ipartek.formacion.uf1845.modelos;

import java.math.*;
import java.time.*;
import java.util.*;

public class Factura {
	public static final BigDecimal IVA = new BigDecimal("0.21");
	
	private Long id;
	private LocalDate fecha;
	private String numero;
	
	private Cliente cliente;
	
	private ArrayList<Linea> lineas = new ArrayList<>();
	
	public BigDecimal getPrecio() {
		throw new RuntimeException("NO está implementado");
	}
	
	public BigDecimal getIva() {
		return getPrecio().multiply(IVA);
	}
	
	public BigDecimal getTotal() {
		return getPrecio().add(getIva());
	}
}

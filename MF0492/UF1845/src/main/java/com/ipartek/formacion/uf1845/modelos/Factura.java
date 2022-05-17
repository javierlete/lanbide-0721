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
	
	public Factura(Long id, LocalDate fecha, String numero, Cliente cliente) {
		setId(id);
		setFecha(fecha);
		setNumero(numero);
		setCliente(cliente);
	}
	
	public BigDecimal getPrecio() {
		throw new RuntimeException("NO está implementado");
	}
	
	public BigDecimal getIva() {
		return getPrecio().multiply(IVA);
	}
	
	public BigDecimal getTotal() {
		return getPrecio().add(getIva());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<Linea> lineas) {
		this.lineas = lineas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fecha, id, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", cliente=" + cliente + "]";
	}
}

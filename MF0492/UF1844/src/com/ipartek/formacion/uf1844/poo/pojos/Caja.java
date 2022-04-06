package com.ipartek.formacion.uf1844.poo.pojos;

public class Caja<T> {
	private T contenido;
	
	public Caja(T contenido) {
		super();
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Caja [contenido=" + contenido + "]";
	}
	
}

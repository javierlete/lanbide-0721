package com.ipartek.formacion.uf1844.poo.pojos;

public class PuntoNombre extends Punto {	
	private String nombre;
	
	public PuntoNombre(Long id, Double x, Double y, String nombre) {
		super(id, x, y);
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "PuntoNombre [nombre=" + nombre + ", id=" + getId() + ", x=" + getX() + ", y=" + getY()
				+ "]";
	}

	
}

package com.ipartek.formacion.uf1844.poo.pojos;

public class Triangulo {
	private Long id;
	private Punto p1, p2, p3;
	// private Punto[] puntos = new Punto[3];
	
	public Triangulo(Long id, Punto p1, Punto p2, Punto p3) {
		super();
		this.id = id;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	@Override
	public String toString() {
		return "Triangulo [id=" + id + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
	}
	
}

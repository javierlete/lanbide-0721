package com.ipartek.formacion.uf1844.poo.pojos;

import java.util.Objects;

public class Punto {
	// 7. Constantes
	public static final Punto ORIGEN = new Punto(null, 0.0, 0.0);

	// *1. Variables privadas de instancia
	private Long id;
	private Double x, y;

	// *3. Source/Generate Constructor using Fields...
	public Punto(Long id, Double x, Double y) {
		// 4. Cambiar el contenido por llamadas a setters
		setId(id);
		setX(x);
		setY(y);
	}

	// 2. Source/Generate Getters and Setters...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	// 6. Source/Generate hashCode and equals...

	@Override
	public int hashCode() {
		return Objects.hash(id, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Objects.equals(id, other.id) && Objects.equals(x, other.x) && Objects.equals(y, other.y);
	}

	// *5. Source/Generate toString...
	@Override
	public String toString() {
		return "Punto [id=" + id + ", x=" + x + ", y=" + y + "]";
	}
}

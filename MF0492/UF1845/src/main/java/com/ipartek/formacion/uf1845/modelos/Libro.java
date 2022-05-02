package com.ipartek.formacion.uf1845.modelos;

import java.math.*;
import java.util.*;

public class Libro {
	
	private Long id;
	private String titulo;
	private String autor;
	private String isbn;
	private BigDecimal precio;
	
	public Libro(Long id, String titulo, String autor, String isbn, BigDecimal precio) {
		setId(id);
		setTitulo(titulo);
		setAutor(autor);
		setIsbn(isbn);
		setPrecio(precio);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, id, isbn, precio, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(id, other.id) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(precio, other.precio) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", precio=" + precio
				+ "]";
	}
	
	
}

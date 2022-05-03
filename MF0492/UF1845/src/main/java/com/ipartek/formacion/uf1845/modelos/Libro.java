package com.ipartek.formacion.uf1845.modelos;

import java.math.*;
import java.util.*;

public class Libro {
	
	private Long id;
	private String titulo;
	private String autor;
	private String isbn;
	private BigDecimal precio;
	
	private TreeMap<String, String> errores = new TreeMap<>();
	
	public Libro(String id, String titulo, String autor, String isbn, String precio) {
		setId(id);
		setTitulo(titulo);
		setAutor(autor);
		setIsbn(isbn);
		setPrecio(precio);
	}
	
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
	
	public void setId(String id) {
		if(id.trim().length() == 0) {
			setId((Long)null);
			return;
		}
		
		try {
			setId(Long.parseLong(id));
		} catch (Exception e) {
			errores.put("id", "No es un número");
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().length() < 3) {
			errores.put("titulo", "El título debe tener más de 3 caracteres");
		}
		
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if(autor != null && autor.trim().length() != 0 && autor.trim().length() < 3) {
			errores.put("autor", "El autor tiene un nombre demasiado corto");
		}
		
		if(autor == null || autor.trim().length() == 0) {
			this.autor = "ANÓNIMO";
			return;
		}
		
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
		if(precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio no puede ser negativo");
		}
		this.precio = precio;
	}
	
	public void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "No es un número");
		}
	}

	public TreeMap<String, String> getErrores() {
		return errores;
	}

	public boolean tieneErrores() {
		return errores.size() > 0;
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

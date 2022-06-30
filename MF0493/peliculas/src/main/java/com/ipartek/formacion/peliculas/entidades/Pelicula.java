package com.ipartek.formacion.peliculas.entidades;

import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "peliculas")
@Data
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String titulo;
	private LocalDate fechaEstreno;
	private BigDecimal coste;
	
	@ManyToMany
	private Set<Artista> directores;
	@OneToMany(mappedBy = "pelicula")
	private Set<Papel> papeles;
	@ManyToMany(mappedBy = "peliculas")
	private Set<Genero> generos;
}

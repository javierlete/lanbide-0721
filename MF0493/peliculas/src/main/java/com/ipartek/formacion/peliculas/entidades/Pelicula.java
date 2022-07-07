package com.ipartek.formacion.peliculas.entidades;

import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.*;
import org.springframework.format.annotation.DateTimeFormat.*;

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
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaEstreno;
	@DecimalMin("0")
	private BigDecimal coste;
	
	@ManyToMany
	private Set<Artista> directores;
	@OneToMany(mappedBy = "pelicula")
	private Set<Papel> papeles;
	@ManyToMany(mappedBy = "peliculas")
	private Set<Genero> generos;
}

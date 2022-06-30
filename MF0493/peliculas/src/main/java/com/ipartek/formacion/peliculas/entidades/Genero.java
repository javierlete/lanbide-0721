package com.ipartek.formacion.peliculas.entidades;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "generos")
@Data
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String tipo;
	
	@ManyToMany
	private Set<Pelicula> peliculas;
}

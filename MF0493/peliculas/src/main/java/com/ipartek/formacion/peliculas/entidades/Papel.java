package com.ipartek.formacion.peliculas.entidades;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.*;

import lombok.*;

@Entity
@Table(name = "papeles")
@Data
public class Papel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	private Pelicula pelicula;
	@ManyToOne
	private Artista artista;
	
	@NotNull
	@NotBlank
	@Length(max = 50)
	private String nombre;
}

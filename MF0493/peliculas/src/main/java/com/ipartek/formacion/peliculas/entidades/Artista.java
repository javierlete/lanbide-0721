package com.ipartek.formacion.peliculas.entidades;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "artistas")
@Data
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nombre;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "artista")
	private Set<Papel> papeles;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(mappedBy = "directores")
	private Set<Pelicula> haDirigido;
}

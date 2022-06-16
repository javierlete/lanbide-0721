package com.ipartek.formacion.lombok.entidades;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="roles")
@Data
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	
	@OneToMany(mappedBy = "rol")
	private Set<Usuario> usuarios;
}

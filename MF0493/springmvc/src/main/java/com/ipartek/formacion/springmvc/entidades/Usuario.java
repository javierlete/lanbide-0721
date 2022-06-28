package com.ipartek.formacion.springmvc.entidades;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="usuarios")
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email, password, nombre;
	
	@Column(length = 20, columnDefinition = "CHAR(20)")
	private String rol;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "usuario")
	private Set<Producto> productos = new HashSet<Producto>();
}

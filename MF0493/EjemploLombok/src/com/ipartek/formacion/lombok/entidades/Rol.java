package com.ipartek.formacion.lombok.entidades;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="roles")
@Data @AllArgsConstructor @NoArgsConstructor
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
	private final Set<Usuario> usuarios = new HashSet<>();
}

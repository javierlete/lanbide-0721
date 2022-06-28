package com.ipartek.formacion.springmvc.entidades;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "productos")
@Data
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre;

	@DecimalMin("0")
	private BigDecimal precio;
	
	@ManyToOne
	private Usuario usuario;
}

package com.ipartek.formacion.springmvc;

import java.math.*;

import javax.validation.constraints.*;

import lombok.*;

@Data
public class Producto {
	private Long id;
	
	@NotBlank
	private String nombre;
	
	@DecimalMin("0")
	private BigDecimal precio;
}

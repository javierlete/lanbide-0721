package com.ipartek.formacion.springmvc;

import java.math.*;

import lombok.*;

@Data
public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
}

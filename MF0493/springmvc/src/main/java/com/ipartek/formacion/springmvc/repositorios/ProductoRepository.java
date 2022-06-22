package com.ipartek.formacion.springmvc.repositorios;

import java.math.*;
import java.util.*;

import org.springframework.data.repository.*;

import com.ipartek.formacion.springmvc.entidades.*;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	List<Producto> findByPrecioBetween(BigDecimal menor, BigDecimal mayor);
}

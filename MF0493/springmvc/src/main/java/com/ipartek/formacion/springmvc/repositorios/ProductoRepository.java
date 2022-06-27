package com.ipartek.formacion.springmvc.repositorios;

import java.math.*;
import java.util.*;

import org.springframework.data.repository.*;
import org.springframework.data.rest.core.annotation.*;

import com.ipartek.formacion.springmvc.entidades.*;

@RepositoryRestResource(collectionResourceRel = "productos", path = "productos")
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long> {
	List<Producto> findByPrecioBetween(BigDecimal menor, BigDecimal mayor);
}

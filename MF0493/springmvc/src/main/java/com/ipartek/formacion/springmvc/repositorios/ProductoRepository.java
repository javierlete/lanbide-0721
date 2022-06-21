package com.ipartek.formacion.springmvc.repositorios;

import org.springframework.data.repository.*;

import com.ipartek.formacion.springmvc.*;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}

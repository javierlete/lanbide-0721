package com.ipartek.formacion.uf1844.almacen.accesodatos;

import java.math.*;

import com.ipartek.formacion.uf1844.almacen.pojos.*;

public interface DaoOrdenador extends Dao<Ordenador> {
	default Iterable<Ordenador> buscarPorMarca(String marca) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	};
	
	default Iterable<Ordenador> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}

package com.ipartek.formacion.uf1845.dal;

import java.util.*;

import com.ipartek.formacion.uf1845.modelos.*;

public class DaoFacturasMemoria implements DaoFacturas {

	private static final TreeMap<Long, Factura> facturas = new TreeMap<>();
	
	// SINGLETON
	private DaoFacturasMemoria() {}
	private static final DaoFacturasMemoria INSTANCIA = new DaoFacturasMemoria();
	public static DaoFacturasMemoria getInstancia() { return INSTANCIA; }
	// FIN SINGLETON
	
	@Override
	public Iterable<Factura> obtenerTodos() {
		return facturas.values();
	}

	@Override
	public Factura obtenerPorId(Long id) {
		return facturas.get(id);
	}

	@Override
	public Factura insertar(Factura factura) {
		Long id = facturas.size() > 0 ? facturas.lastKey() + 1L : 1L;
		factura.setId(id);
		facturas.put(factura.getId(), factura);
		return factura;
	}

	@Override
	public Factura modificar(Factura factura) {
		facturas.put(factura.getId(), factura);
		return factura;
	}

	@Override
	public void borrar(Long id) {
		facturas.remove(id);
	}

}

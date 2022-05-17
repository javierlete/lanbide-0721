package com.ipartek.formacion.uf1845.dal;

import com.ipartek.formacion.uf1845.modelos.*;

public class DaoClientesMemoria implements DaoClientes {

	private DaoClientesMemoria() {}
	private static final DaoClientesMemoria INSTANCIA = new DaoClientesMemoria();
	public static DaoClientes getInstancia() { return INSTANCIA; }
	
	@Override
	public Iterable<Cliente> obtenerTodos() {
		throw new RuntimeException("NO IMPLEMENTADO");
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		System.err.println("No está implementado, sólo datos de ejemplo");
		return new Cliente(1L, "Nombre1", "Dirección1", "CP1", "Provincia1", "CIF1");
	}

	@Override
	public Cliente insertar(Cliente objeto) {
		throw new RuntimeException("NO IMPLEMENTADO");
	}

	@Override
	public Cliente modificar(Cliente objeto) {
		throw new RuntimeException("NO IMPLEMENTADO");
	}

	@Override
	public void borrar(Long id) {
		throw new RuntimeException("NO IMPLEMENTADO");
	}

}

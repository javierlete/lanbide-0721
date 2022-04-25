package com.ipartek.formacion.uf1844.almacen.accesodatos;

import java.math.*;
import java.time.*;
import java.util.*;

import com.ipartek.formacion.uf1844.almacen.pojos.*;

public class DaoOrdenadorMemoria implements DaoOrdenador {
	private static final TreeMap<Long, Ordenador> ordenadores = new TreeMap<>() {
		private static final long serialVersionUID = 353419224216886319L;

		{
			put(1L, new Ordenador(1L, "Apple", "MacBook 13\"", LocalDate.now(), new BigDecimal("1234")));
			put(2L, new Ordenador(2L, "Toshiba", "Satellite", LocalDate.now(), new BigDecimal("1000")));
			put(3L, new Ordenador(3L, "HP", "dv5", LocalDate.now(), new BigDecimal("800")));
		}
	};
	
	// SINGLETON
	private DaoOrdenadorMemoria() {}
	private static final DaoOrdenadorMemoria INSTANCIA = new DaoOrdenadorMemoria();
	public static final DaoOrdenadorMemoria getInstancia() { return INSTANCIA; }
	// FIN SINGLETON
	
	@Override
	public Iterable<Ordenador> obtenerTodos() {
		return ordenadores.values();
	}

	@Override
	public Ordenador obtenerPorId(Long id) {
		return ordenadores.get(id);
	}

	@Override
	public void insertar(Ordenador ordenador) {
		Long id = ordenadores.size() > 0 ? ordenadores.lastKey() + 1L : 1L;
		ordenador.setId(id);
		ordenadores.put(id, ordenador);
	}

	@Override
	public void modificar(Ordenador ordenador) {
		ordenadores.put(ordenador.getId(), ordenador);
	}

	@Override
	public void borrar(Long id) {
		ordenadores.remove(id);
	}

	@Override
	public Iterable<Ordenador> buscarPorMarca(String marca) {
		return ordenadores.values().stream().filter(o -> o.getMarca().contains(marca)).toList();
	}

	@Override
	public Iterable<Ordenador> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		ArrayList<Ordenador> filtrados = new ArrayList<>();
		
		for(Ordenador o: ordenadores.values()) {
			// if(o.getPrecio() >= minimo && o.getPrecio() <= maximo)
			if(o.getPrecio().compareTo(minimo) >= 0 && o.getPrecio().compareTo(maximo) <= 0) {
				filtrados.add(o);
			}
		}
		
		return filtrados;
	}
	
	
}

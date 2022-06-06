package com.ipartek.formacion.mf0492.uf1846.dal;

import java.math.*;
import java.util.*;

import com.ipartek.formacion.mf0492.uf1846.modelos.*;

class DaoPizarraMemoria implements DaoPizarra {
	private static final TreeMap<Long, Pizarra> pizarras = new TreeMap<>();
	
	static {
		pizarras.put(1L, new Pizarra(1L, "Velleda", 123, 54, new BigDecimal("123"), Pizarra.Tipo.Velleda));
		pizarras.put(2L, new Pizarra(2L, "Tizarra", 223, 54, new BigDecimal("223"), Pizarra.Tipo.Tiza));
		pizarras.put(3L, new Pizarra(3L, "Papelarra", 323, 54, new BigDecimal("323"), Pizarra.Tipo.RotaFolios));
	}

	@Override
	public Iterable<Pizarra> obtenerTodos() {
		return pizarras.values();
	}
	
	
}

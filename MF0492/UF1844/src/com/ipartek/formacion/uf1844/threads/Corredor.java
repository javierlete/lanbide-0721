package com.ipartek.formacion.uf1844.threads;

import java.util.*;

public class Corredor implements Runnable {
	private Long dorsal;
	private Integer posicion = 0;
	
	public Corredor(Long dorsal) {
		this.dorsal = dorsal;
	}
	
	public void correr() {
		for(posicion = 1; posicion <= 100; posicion++) {
			// System.out.println(dorsal + ": " + posicion);
			try {
				Thread.sleep(new Random().nextLong(1, 200));
			} catch (InterruptedException e) {}
		}
	}

	public Long getDorsal() {
		return dorsal;
	}

	public Integer getPosicion() {
		return posicion;
	}
	
	public boolean haTerminado() {
		return posicion > 100;
	}

	@Override
	public void run() {
		correr();
	}
}

package com.ipartek.formacion.uf1844.poo.pojos.ejemplointerfaces;

public class Balon extends ObjetoDeporte implements Rodable {

	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}

}

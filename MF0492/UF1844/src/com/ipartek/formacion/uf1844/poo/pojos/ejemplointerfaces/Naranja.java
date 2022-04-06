package com.ipartek.formacion.uf1844.poo.pojos.ejemplointerfaces;

public class Naranja extends Fruto implements Rodable, Comestible {

	private boolean porElSuelo = false;
	
	@Override
	public void comer() {
		if(porElSuelo) {
			System.out.println("Puaj que asco");
		} else {
			System.out.println("Ñam que rica");
		}
	}

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		porElSuelo = true;
	}

}

package com.ipartek.formacion.uf1844.poo.pruebas;

import java.util.ArrayList;

import com.ipartek.formacion.uf1844.poo.pojos.ejemplointerfaces.Balon;
import com.ipartek.formacion.uf1844.poo.pojos.ejemplointerfaces.Comestible;
import com.ipartek.formacion.uf1844.poo.pojos.ejemplointerfaces.Naranja;
import com.ipartek.formacion.uf1844.poo.pojos.ejemplointerfaces.Rodable;

public class EjemploInterfaces {
	public static void main(String[] args) {
		ArrayList<Rodable> rodables = new ArrayList<>();

		rodables.add(new Balon());
		rodables.add(new Naranja());

		for (Rodable r : rodables) {
			if (r instanceof Comestible) {
				Comestible c = (Comestible) r;
				c.comer();
			}

			r.rodar();

			if (r instanceof Comestible) {
				Comestible c = (Comestible) r;
				c.comer();
			}
		}
	}
}

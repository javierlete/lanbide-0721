package com.ipartek.formacion.uf1844.threads;

public class Carrera {

	public static void main(String[] args) {
		Corredor c1 = new Corredor(1L);
		Corredor c2 = new Corredor(2L);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
//		c1.correr();
//		c2.correr();
		
		t1.start();
		t2.start();
		
		while (!c1.haTerminado() && !c2.haTerminado()) {
			System.out.println(c1.getDorsal() + ": " + c1.getPosicion());
			System.out.println(c2.getDorsal() + ": " + c2.getPosicion());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}

}

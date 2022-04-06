package com.ipartek.formacion.uf1844.poo.pruebas;

public class PruebaClasesAbstractas {
	public static void main(String[] args) {
		Number[] arr = new Number[2];
		
		arr[0] = 5; //new Integer(5);
		arr[1] = 7.8; //new Double(7.8);
		
		for(Number n: arr) {
			System.out.println(n.intValue());
			System.out.println(n.doubleValue());
		}
	}
}

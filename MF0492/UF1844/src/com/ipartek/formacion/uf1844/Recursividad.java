package com.ipartek.formacion.uf1844;

public class Recursividad {

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

	/**
	 * 5! = 5 * 4 * 3 * 2 * 1 5! = 5 * 4! 4! = 4 * 3! 3! = 3 * 2! 2! = 2 * 1! 1! = 1
	 * 
	 * @param n número a probar
	 * @return factorial resultante
	 */
	private static int factorial(int n) {
		// return n == 1 ? 1 : n * factorial(n - 1);

		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}

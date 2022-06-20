package com.ipartek.formacion;

public class SalidaConsolaEstandar implements SalidaConsola {
	@Override
	public void mostrar(String mensaje) {
		System.out.println(mensaje);
	}
}

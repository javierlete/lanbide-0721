package com.ipartek.formacion;

public class SalidaConsolaDecorada implements SalidaConsola {
	@Override
	public void mostrar(String mensaje) {
		System.out.println("---" + mensaje + "---");
	}
}

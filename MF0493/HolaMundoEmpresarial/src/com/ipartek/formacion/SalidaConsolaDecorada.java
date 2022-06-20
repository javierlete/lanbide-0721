package com.ipartek.formacion;

import org.springframework.stereotype.*;

@Component
public class SalidaConsolaDecorada implements SalidaConsola {
	@Override
	public void mostrar(String mensaje) {
		System.out.println("---" + mensaje + "---");
	}
}

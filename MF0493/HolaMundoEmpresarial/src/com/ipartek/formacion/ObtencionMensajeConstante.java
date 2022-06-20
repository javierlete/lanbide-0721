package com.ipartek.formacion;

import org.springframework.stereotype.*;

@Component
public class ObtencionMensajeConstante implements ObtencionMensaje {

	@Override
	public String getMensaje() {
		return "Hola fijo";
	}

}

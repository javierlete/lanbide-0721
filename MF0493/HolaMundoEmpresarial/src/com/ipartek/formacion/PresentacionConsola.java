package com.ipartek.formacion;

import java.io.*;
import java.lang.reflect.*;

public class PresentacionConsola {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Fabrica f = new Fabrica();

		SalidaConsola sc = f.getSalidaConsola(); // new SalidaConsolaDecorada();
		ObtencionMensaje om = f.getObtencionMensaje(); // new ObtencionMensajeConsola();

		sc.mostrar(om.getMensaje());
	}
}

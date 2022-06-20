package com.ipartek.formacion;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class Fabrica {
	private ObtencionMensaje obtencionMensaje;
	private SalidaConsola salidaConsola;
	
	public Fabrica() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Properties props = new Properties();
		props.load(Fabrica.class.getClassLoader().getResourceAsStream("configuracion.properties"));
		
		obtencionMensaje = (ObtencionMensaje) Class.forName(props.getProperty("obtencionMensaje")).getConstructor().newInstance();
		salidaConsola = (SalidaConsola) Class.forName(props.getProperty("salidaConsola")).getConstructor().newInstance();
	}
	
	public ObtencionMensaje getObtencionMensaje() {
		return obtencionMensaje;
	}
	
	public SalidaConsola getSalidaConsola() {
		return salidaConsola;
	}
}

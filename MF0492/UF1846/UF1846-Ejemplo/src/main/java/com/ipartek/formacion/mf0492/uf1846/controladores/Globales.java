package com.ipartek.formacion.mf0492.uf1846.controladores;

import com.ipartek.formacion.mf0492.uf1846.dal.*;

public class Globales {
	public static final String RAIZ_VISTAS = "/WEB-INF/vistas";
	
	public static final DaoFactory FABRICA = new DaoFactory();
	public static final DaoPizarra DAO = FABRICA.getDaoPizarra();
}

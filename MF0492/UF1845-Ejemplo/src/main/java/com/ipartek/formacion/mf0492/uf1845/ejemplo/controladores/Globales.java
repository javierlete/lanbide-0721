package com.ipartek.formacion.mf0492.uf1845.ejemplo.controladores;

import com.ipartek.formacion.mf0492.uf1845.ejemplo.dal.*;

public class Globales {
	static final DaoProyecto DAO = DaoProyectoMemoria.getInstancia();
	static final DaoUsuario DAO_USUARIO = DaoUsuarioMemoria.getInstancia();
	public static final String VISTAS = "/WEB-INF/vistas";
}

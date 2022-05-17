package com.ipartek.formacion.uf1845.configuracion;

import com.ipartek.formacion.uf1845.dal.*;

public class Globales {
	public static final DaoLibros daoLibros = DaoLibrosMemoria.getInstancia();
	public static final DaoClientes daoClientes = DaoClientesMemoria.getInstancia();
}

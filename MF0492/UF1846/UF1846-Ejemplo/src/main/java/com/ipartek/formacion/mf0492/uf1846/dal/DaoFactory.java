package com.ipartek.formacion.mf0492.uf1846.dal;

import java.io.*;
import java.util.*;

public class DaoFactory {
	private DaoPizarra daoPizarra;
	
	public DaoFactory() {
		Properties props = new Properties();
		
		try {
			props.load(DaoFactory.class.getClassLoader().getResourceAsStream("configuracion.properties"));
			
			String url = (String) props.getProperty("dal.url");
			String user = (String) props.getProperty("dal.user");
			String pass = (String) props.getProperty("dal.pass");
			String tipo = (String) props.getProperty("dal.tipo");
			String driver = (String) props.getProperty("dal.driver");
			
			switch(tipo) {
			case "mysql":
				daoPizarra = new DaoPizarraMySql(driver, url, user, pass);
				break;
			case "memoria":
				daoPizarra = new DaoPizarraMemoria();
				break;
			default:
				throw new DalException("No conozco el tipo " + tipo);
			}
			
			
		} catch (IOException e) {
			throw new DalException("No se ha podido leer la configuración", e);
		}
	}
	
	public DaoPizarra getDaoPizarra() {
		return daoPizarra;
	}
}

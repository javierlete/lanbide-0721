package com.ipartek.formacion.mf0492.uf1846.dal;

import java.sql.*;
import java.util.*;

import com.ipartek.formacion.mf0492.uf1846.modelos.*;
import com.ipartek.formacion.mf0492.uf1846.modelos.Pizarra.*;

class DaoPizarraMySql implements DaoPizarra {
	private static final String SQL_SELECT = "SELECT * FROM pizarras";
	private String url, user, pass, driver;

	public DaoPizarraMySql(String driver, String url, String user, String pass) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;

		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha encontrado el driver " + this.driver, e);
		}
	}

	private Connection conectar() {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new DalException("No he podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Pizarra> obtenerTodos() {
		try (Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Pizarra> pizarras = new ArrayList<>();
			Pizarra pizarra = null;
			Tipo tipo;

			while (rs.next()) {
				tipo = Pizarra.Tipo.valueOf(rs.getString("tipo"));
				pizarra = new Pizarra(rs.getLong("id"), rs.getString("marca"), rs.getInt("ancho"), rs.getInt("alto"),
						rs.getBigDecimal("precio"), tipo);
				
				pizarras.add(pizarra);
			}
			
			return pizarras;
		} catch (SQLException e) {
			throw new DalException("No se han podido obtener todos los registros", e);
		}
	}

}

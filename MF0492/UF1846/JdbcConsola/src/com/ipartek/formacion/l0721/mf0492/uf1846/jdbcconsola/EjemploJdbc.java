package com.ipartek.formacion.l0721.mf0492.uf1846.jdbcconsola;

import java.sql.*;

public class EjemploJdbc {

	private static final String URL = "jdbc:mysql://localhost:3306/uf1846";
	private static final String USER = "root";
	private static final String PASS = "admin";
	private static final String SQL_SELECT = "SELECT * FROM usuarios";
	private static final String SQL_SELECT_ID = "SELECT * FROM usuarios WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";
	
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT);
		
		while(rs.next()) {
			System.out.printf("%s, %s, %s\n", rs.getString("id"), rs.getString("email"), rs.getString("password"));
		}
		
		PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
		
		pst.setString(1, "modificado@modificado.net");
		pst.setString(2, "modificado");
		pst.setLong(3, 2L);
		
		int numeroRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
	}

}

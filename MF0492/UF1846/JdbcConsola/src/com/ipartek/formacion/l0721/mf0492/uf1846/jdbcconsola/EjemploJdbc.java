package com.ipartek.formacion.l0721.mf0492.uf1846.jdbcconsola;

import java.sql.*;

public class EjemploJdbc {

	private static final String URL = "jdbc:mysql://localhost:3306/uf1846";
	private static final String USER = "root";
	private static final String PASS = "admin";
	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	private static final String SQL_SELECT_ID = "SELECT id, email, password FROM usuarios WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASS);

		// SELECT
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT);

		while (rs.next()) {
			System.out.printf("%s, %s, %s\n", rs.getString("id"), rs.getString("email"), rs.getString("password"));
		}

		// SELECT por ID
		PreparedStatement pstSelectId = con.prepareStatement(SQL_SELECT_ID);

		pstSelectId.setLong(1, 2L);

		rs = pstSelectId.executeQuery();

		if (rs.next()) {
			System.out.printf("%s, %s, %s\n", rs.getString("id"), rs.getString("email"), rs.getString("password"));
		} else {
			System.out.println("No se ha encontrado");
		}

		// INSERT
		PreparedStatement pstInsert = con.prepareStatement(SQL_INSERT);

		pstInsert.setString(1, "novisimo@modificado.net");
		pstInsert.setString(2, "nuevo");

		int numeroRegistrosModificados = pstInsert.executeUpdate();

		System.out.println(numeroRegistrosModificados);

		// UPDATE
		PreparedStatement pstUpdate = con.prepareStatement(SQL_UPDATE);

		pstUpdate.setString(1, "modificado@modificado.net");
		pstUpdate.setString(2, "modificado");
		pstUpdate.setLong(3, 4L);

		numeroRegistrosModificados = pstUpdate.executeUpdate();

		System.out.println(numeroRegistrosModificados);

		// DELETE
		PreparedStatement pstDelete = con.prepareStatement(SQL_DELETE);

		pstDelete.setLong(1, 6L);

		numeroRegistrosModificados = pstDelete.executeUpdate();

		System.out.println(numeroRegistrosModificados);
	}

}

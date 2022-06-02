package com.ipartek.formacion.l721.mf0492.uf1846.dal;

import java.sql.*;
import java.util.*;

import com.ipartek.formacion.l721.mf0492.uf1846.entidades.*;

public class DaoUsuarioMySql implements DaoUsuario {
	private static final String URL = "jdbc:mysql://localhost:3306/uf1846";
	private static final String USER = "uf1846user";
	private static final String PASS = "uf1846pass";

	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	private static final String SQL_SELECT_ID = "SELECT * FROM usuarios u, roles r WHERE r.id = u.roles_id AND u.id = ?";

	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password, roles_id) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email = ?, password = ?, roles_id = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha encontrado el driver de MySQL", e);
		}
	}

	// SINGLETON
	private DaoUsuarioMySql() {
	}

	private static final DaoUsuarioMySql INSTANCIA = new DaoUsuarioMySql();

	public static DaoUsuarioMySql getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Usuario> usuarios = new ArrayList<>();
			Usuario usuario;

			while (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"), null);
				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new DalException("Error al pedir los registros", e);
		}
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;
				Rol rol = null;
				
				if (rs.next()) {
					rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"));							usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"), rol);
				}

				return usuario;
			}
		} catch (SQLException e) {
			throw new DalException("Error al pedir los registros", e);
		}
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setLong(3, usuario.getRol().getId());

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new DalException("Se ha detectado un número de cambios distinto de 1");
			}

			return usuario;
		} catch (SQLException e) {
			throw new DalException("Error al insertar los registros", e);
		}
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setLong(3,  usuario.getRol().getId());
			pst.setLong(4, usuario.getId());

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new DalException("Se ha detectado un número de cambios distinto de 1");
			}

			return usuario;
		} catch (SQLException e) {
			throw new DalException("Error al modificar los registros", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

			pst.setLong(1, id);

			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new DalException("Se ha detectado un número de cambios distinto de 1");
			}

		} catch (SQLException e) {
			throw new DalException("Error al borrar el registro", e);
		}
	}

}

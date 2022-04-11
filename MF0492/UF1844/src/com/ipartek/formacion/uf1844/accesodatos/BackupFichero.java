package com.ipartek.formacion.uf1844.accesodatos;

import java.io.*;
import java.util.*;

public class BackupFichero<T> implements Backupable<T> {
	private String nombreFichero;
	
	public BackupFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	@Override
	public void backup(Iterable<T> objetos) {
		ArrayList<T> al = new ArrayList<>();
		
		for(T objeto: objetos) {
			al.add(objeto);
		}
		
		try (FileOutputStream fos = new FileOutputStream(nombreFichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(al);
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido escribir el fichero", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> restore() {
		try (FileInputStream fis = new FileInputStream(nombreFichero);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (Iterable<T>)ois.readObject();
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido escribir el fichero", e);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado la clase necesaria", e);
		}
	}

}

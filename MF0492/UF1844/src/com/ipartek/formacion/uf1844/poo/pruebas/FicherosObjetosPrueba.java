package com.ipartek.formacion.uf1844.poo.pruebas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ipartek.formacion.uf1844.poo.pojos.Empleado;
import com.ipartek.formacion.uf1844.poo.pojos.Oficina;
import com.ipartek.formacion.uf1844.poo.pojos.Persona;

public class FicherosObjetosPrueba {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("oficina.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Oficina o = new Oficina("Bilbao");

		o.agregar(new Persona());
		o.agregar(new Empleado(3L, "Pepe", "1234123412341234"));
		o.agregar(new Persona(2L, "Javier"));

		oos.writeObject(o);
		
		o = null;
		
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("oficina.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Oficina o2 = (Oficina) ois.readObject();
		
		for (Persona persona : o2.getPersonas()) {
			System.out.println(persona.aTexto());
		}

		ois.close();
		fis.close();
	}
}

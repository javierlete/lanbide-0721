package com.ipartek.formacion.uf1844.sockets;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {

	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("Arrancando cliente");

		try (Socket s = new Socket("localhost", 1234);
				Scanner sc = new Scanner(s.getInputStream());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH)) {

			System.out.println("Iniciada conexión");

			System.out.println(sc.nextLine());

			pw.println("Texto a poner en mayúsculas");

			System.out.println(sc.nextLine());

		} catch (IOException e) {
			System.err.println("Error en el cliente");
			e.printStackTrace();
		}
	}

}

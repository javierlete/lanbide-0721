package com.ipartek.formacion.uf1844.sockets;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {

	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("Arrancando servidor");
		
		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				Scanner sc = new Scanner(s.getInputStream());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH)) {
			
			System.out.println("Recibida conexión");
			
			pw.println("Bienvenido al servidor MAYUSCULATOR");
			
			String texto = sc.nextLine();
			
			pw.println(texto.toUpperCase());
		} catch (IOException e) {
			System.err.println("Error en el servidor");
			e.printStackTrace();
		}
	}

}

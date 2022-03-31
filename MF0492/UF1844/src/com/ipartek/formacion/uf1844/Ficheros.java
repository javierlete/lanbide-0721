package com.ipartek.formacion.uf1844;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("ficheros.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Hola a todos");
		pw.println("Nueva línea");
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader("ficheros.txt");
		Scanner sc = new Scanner(fr);
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
		fr.close();
		
		fr = new FileReader("ficheros.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		
		while((linea = br.readLine()) != null) {
			System.out.println(linea);
		}
		
		br.close();
		fr.close();
	}

}

package com.ipartek.formacion;

import java.util.*;

public class ObtencionMensajeConsola implements ObtencionMensaje {

	@Override
	public String getMensaje() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el texto: ");
		String linea = sc.nextLine();
		
		sc.close();
		
		return linea;
	}

}

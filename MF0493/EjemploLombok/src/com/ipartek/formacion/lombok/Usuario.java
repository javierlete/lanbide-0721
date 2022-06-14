package com.ipartek.formacion.lombok;

import lombok.*;

@Data
public class Usuario {
	private Long id;
	private String email, password;
	
	public void setEmail(String email) {
		if(email != null && !email.contains("@")) {
			throw new RuntimeException("No se admiten emails sin arroba");
		}
		
		this.email = email;
	}
}

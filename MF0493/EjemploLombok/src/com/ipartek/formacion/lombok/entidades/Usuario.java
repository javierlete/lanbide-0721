package com.ipartek.formacion.lombok.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="usuarios")
@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email, password;
	
	public void setEmail(String email) {
		if(email != null && !email.contains("@")) {
			throw new RuntimeException("No se admiten emails sin arroba");
		}
		
		this.email = email;
	}
}

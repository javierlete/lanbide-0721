package com.ipartek.formacion.uf1844.poo.pojos;

import java.io.Serializable;
import java.util.HashSet;

public class Oficina implements Serializable {

	private static final long serialVersionUID = -3252870650085849971L;
	
	private Long id;
	private String ciudad;

	//private Persona[] personas = new Persona[30];
	private HashSet<Persona> personas = new HashSet<>();

	public Oficina(Long id, String ciudad) {
		setId(id);
		setCiudad(ciudad);
	}
	
	public Oficina(String ciudad) {
		this(null, ciudad);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void agregar(Persona persona) {
		if(persona == null) {
			throw new RuntimeException("No se ha recibido ninguna persona");
		}
		
		personas.add(persona);
	}
	
	public Iterable<Persona> getPersonas() {
		return personas;
	}
	
	public Persona getPersona(Long id) {
		for(Persona p: personas) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
		
//		return personas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}
	
	public void borrarPersona(Long id) {
		personas.remove(getPersona(id));
	}
}













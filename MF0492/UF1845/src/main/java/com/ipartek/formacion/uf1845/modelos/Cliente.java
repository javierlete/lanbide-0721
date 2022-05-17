package com.ipartek.formacion.uf1845.modelos;

import java.util.*;

public class Cliente {
	private Long id;
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String provincia;
	private String cif;
	
	public Cliente(Long id, String nombre, String direccion, String codigoPostal, String provincia, String cif) {
		setId(id);
		setNombre(nombre);
		setDireccion(direccion);
		setCodigoPostal(codigoPostal);
		setProvincia(provincia);
		setCif(cif);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cif, codigoPostal, direccion, id, nombre, provincia);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif) && Objects.equals(codigoPostal, other.codigoPostal)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(provincia, other.provincia);
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", provincia=" + provincia + ", cif=" + cif + "]";
	}
	
	
	
}

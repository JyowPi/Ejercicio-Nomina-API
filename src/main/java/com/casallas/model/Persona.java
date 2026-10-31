package com.casallas.model;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4865213817103450725L;
	protected String nombre="";
	protected String apellido="";
	protected String correo="";
	protected long identificacion=0;
	
	public Persona(String nombre, String apellido, String correo, long identificacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.identificacion = identificacion;
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", identificacion="
				+ identificacion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, correo, Long.valueOf(identificacion), nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(correo, other.correo)
				&& identificacion == other.identificacion && Objects.equals(nombre, other.nombre);
	}
	
	
}
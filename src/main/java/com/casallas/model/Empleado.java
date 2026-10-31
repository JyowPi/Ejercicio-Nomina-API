package com.casallas.model;

import java.io.Serializable;
import java.util.Objects;

public class Empleado extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2112611067333997754L;
	private Double salario;
	private int diasTrabajados = 0;
	private String cargo = "";
	
	
	public Empleado(String nombre, String apellido, String correo, long identificacion, Double salario,
			int diasTrabajados, String cargo) {
		super(nombre, apellido, correo, identificacion);
		this.salario = salario;
		this.diasTrabajados = diasTrabajados;
		this.cargo = cargo;
	}
	

	public Empleado() {
		
	}


	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "Empleado [salario=" + salario + ", diasTrabajados=" + diasTrabajados + ", cargo=" + cargo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cargo, diasTrabajados, salario);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(cargo, other.cargo) && diasTrabajados == other.diasTrabajados
				&& Objects.equals(salario, other.salario);
	}
	
	
	
}

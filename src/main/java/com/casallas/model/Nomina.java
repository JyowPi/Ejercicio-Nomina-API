package com.casallas.model;

import java.io.Serializable;
import java.util.Objects;

public class Nomina implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8771583160963197634L;
	private int idNomina;
	private double auxTransporte;
	private  double dctoSalud;
	private double salarioDeve;
	private double pension;
	private double netoPagar;
	private Empleado empleado;
	

	public Nomina() {
		super();
	}


	public Nomina(int idNomina, double auxTransporte, double dctoSalud, double salarioDeve, double pension,
			double netoPagar, Empleado empleado) {
		super();
		this.idNomina = idNomina;
		this.auxTransporte = auxTransporte;
		this.dctoSalud = dctoSalud;
		this.salarioDeve = salarioDeve;
		this.pension = pension;
		this.netoPagar = netoPagar;
		this.setEmpleado(empleado);
	}




	public int getIdNomina() {
		return idNomina;
	}



	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}



	public double getSalarioDeve() {
		return salarioDeve;
	}

	public void setSalarioDeve(double salarioDeve) {
		this.salarioDeve = salarioDeve;
	}

	public double getPension() {
		return pension;
	}

	public void setPension(double pension) {
		this.pension = pension;
	}


	public double getAuxTransporte() {
		return auxTransporte;
	}

	public void setAuxTransporte(double auxTransporte) {
		this.auxTransporte = auxTransporte;
	}

	public double getDctoSalud() {
		return dctoSalud;
	}

	public void setDctoSalud(double dctoSalud) {
		this.dctoSalud = dctoSalud;
	}

	


	public double getNetoPagar() {
		return netoPagar;
	}

	public void setNetoPagar(double netoPagar) {
		this.netoPagar = netoPagar;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	@Override
	public String toString() {
		return "Nomina [idNomina=" + idNomina + ", auxTransporte=" + auxTransporte + ", dctoSalud=" + dctoSalud
				+ ", salarioDeve=" + salarioDeve + ", pension=" + pension + ", netoPagar=" + netoPagar + ", empleado="
				+ empleado + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(Double.valueOf(auxTransporte), Double.valueOf(dctoSalud), empleado,
				Integer.valueOf(idNomina), Double.valueOf(netoPagar), Double.valueOf(pension),
				Double.valueOf(salarioDeve));
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nomina other = (Nomina) obj;
		return Double.doubleToLongBits(auxTransporte) == Double.doubleToLongBits(other.auxTransporte)
				&& Double.doubleToLongBits(dctoSalud) == Double.doubleToLongBits(other.dctoSalud)
				&& Objects.equals(empleado, other.empleado) && idNomina == other.idNomina
				&& Double.doubleToLongBits(netoPagar) == Double.doubleToLongBits(other.netoPagar)
				&& Double.doubleToLongBits(pension) == Double.doubleToLongBits(other.pension)
				&& Double.doubleToLongBits(salarioDeve) == Double.doubleToLongBits(other.salarioDeve);
	}





	
	

}
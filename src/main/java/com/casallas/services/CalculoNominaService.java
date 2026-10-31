package com.casallas.services;

import org.springframework.stereotype.Service;

import com.casallas.model.Empleado;
import com.casallas.model.Nomina;

@Service
public class CalculoNominaService {

    private static final double SMMLV = 1500000;
    private static final double AUXILIO_TRANSPORTE = 250000;
    private static final double PORCENTAJE_SALUD = 0.04;
    private static final double PORCENTAJE_PENSION = 0.04;

    public CalculoNominaService() {
    }

    public Nomina calcular(Empleado e) {

        double salarioDiario = e.getSalario() / 30.0;
        double devengado = salarioDiario * e.getDiasTrabajados();

        double auxilio = 0;
        if (e.getSalario() <= (2 * SMMLV)) {
            auxilio = (AUXILIO_TRANSPORTE / 30.0) * e.getDiasTrabajados();
        }

        double salud = devengado * PORCENTAJE_SALUD;
        double pension = devengado * PORCENTAJE_PENSION;
        double neto = devengado - salud - pension + auxilio;

        Nomina n = new Nomina();
        n.setEmpleado(e);
        n.setSalarioDeve(redondear(devengado));
        n.setAuxTransporte(redondear(auxilio));
        n.setDctoSalud(redondear(salud));
        n.setPension(redondear(pension));
        n.setNetoPagar(redondear(neto));

        return n;
    }

    private double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

}
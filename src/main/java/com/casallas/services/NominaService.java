package com.casallas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casallas.model.Empleado;
import com.casallas.model.Nomina;
import com.casallas.repository.RepositoryEmpleado;
import com.casallas.repository.RepositoryNomina;


@Service
public class NominaService {
	
	@Autowired
	private RepositoryEmpleado repoEmpleado;

	@Autowired
	private RepositoryNomina repoNomina;
	
	@Autowired
	private CalculoNominaService cal;

	
	public NominaService() {
	}
	
	public List<Nomina> obtenerDatos() {
		return repoNomina.findAll();
	}
	
	public Optional<Nomina> buscarId(int id) {
		return repoNomina.findId(id);
	}
	
	public void eliminar(int id) {
		repoNomina.delete(id);
	}
	
	public void actualizar(Nomina n) {
		repoNomina.update(n);
	}
	
	public void guardar(Nomina n) {
		if (n.getIdNomina() == 0) {
			n.setIdNomina(repoNomina.nextId());
		}
		repoNomina.save(n);
	}
	
	public String calcularYGuardar(Empleado e) {

        // 1. Validaciones manuales
        if (e.getNombre() == null || e.getNombre().isEmpty()
                || e.getApellido() == null || e.getApellido().isEmpty()
                || e.getCorreo() == null || e.getCorreo().isEmpty()
                || e.getIdentificacion() <= 0
                || e.getSalario() == null || e.getSalario() <= 0
                || e.getDiasTrabajados() <= 0
                || e.getDiasTrabajados() > 30) {
            return "Complete los datos correctamente";
        }

        // 2. Si el empleado no existe, se registra; si ya existe, no se duplica
        if (repoEmpleado.findId(e.getIdentificacion()).isEmpty()) {
            repoEmpleado.save(e);
        }

        // 3. Cálculo delegado
        Nomina n = cal.calcular(e);

        // 4. Id y persistencia
        n.setIdNomina(repoNomina.nextId());
        repoNomina.save(n);

        return "Creado";
    }


}

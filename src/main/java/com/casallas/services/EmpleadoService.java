package com.casallas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casallas.model.Empleado;
import com.casallas.repository.RepositoryEmpleado;

@Service
public class EmpleadoService {

	@Autowired
	private RepositoryEmpleado repoEmpleado;
	
	public EmpleadoService() {
	}
	
	public List<Empleado> obtenerDatos() {
		return repoEmpleado.findAll();
	}
	
	public Optional<Empleado> buscarId(long id) {
		return repoEmpleado.findId(id);
	}
	
	public void eliminar(long id) {
		repoEmpleado.delete(id);
	}
	
	public void actualizar(Empleado n) {
		repoEmpleado.update(n);
	}
	
	public String guardar(Empleado n) {
		if (repoEmpleado.findId(n.getIdentificacion()).isPresent()) {
			return "La identificación ya existe";
		}
		repoEmpleado.save(n);
		return "Creado";
	}
}

package com.casallas.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.casallas.model.Empleado;

@Repository
public class RepositoryEmpleado {

	private List<Empleado> listaP = new ArrayList<Empleado>();

	public RepositoryEmpleado() {
		if (listaP.isEmpty()) {
			Empleado obj = new Empleado("juan", "casallas", "jp@gmail.com", 1236478451, 2000000.0, 30, "dev");
			listaP.add(obj);
			
			System.out.println("crea obj");
		}
	}

	public List<Empleado> findAll() {

		return listaP;
	}

	public void save(Empleado dto) {
		listaP.add(dto);
	}

	public void delete(long id) {

		listaP.removeIf(p -> p.getIdentificacion() == id);
	}

	public Optional<Empleado> findId(long id) {
				 
		return listaP.stream().filter(p -> p.getIdentificacion() == id).findFirst();
	}

	public void update(Empleado dto) {

		for (int i = 0; i < listaP.size(); i++) {
			if (listaP.get(i).getIdentificacion() == dto.getIdentificacion()) {
				listaP.set(i, dto);
				break;
			}

		}

	}
}

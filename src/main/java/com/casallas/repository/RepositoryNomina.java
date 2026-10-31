package com.casallas.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.casallas.model.Nomina;

@Repository
public class RepositoryNomina {

	private List<Nomina> listaP = new ArrayList<Nomina>();

	public RepositoryNomina() {
	}

	public List<Nomina> findAll() {

		return listaP;
	}
	
	private int consecutivo = 1;

	public int nextId() {
	    return consecutivo++;
	}

	public void save(Nomina dto) {
		listaP.add(dto);
	}

	public void delete(int id) {

		listaP.removeIf(p -> p.getIdNomina() == id);
	}

	public Optional<Nomina> findId(int id) {
				 
		return listaP.stream().filter(p -> p.getIdNomina() == id).findFirst();
	}

	public void update(Nomina dto) {

		for (int i = 0; i < listaP.size(); i++) {
			if (listaP.get(i).getIdNomina() == dto.getIdNomina()) {
				listaP.set(i, dto);
				break;
			}

		}

	}
}

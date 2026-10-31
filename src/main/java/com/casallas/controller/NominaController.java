package com.casallas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casallas.model.Empleado;
import com.casallas.model.Nomina;
import com.casallas.services.NominaService;



@RestController
@RequestMapping("/com/empresa/nomina")
public class NominaController {
	
	@Autowired
	private NominaService ns;
	
	@GetMapping("/autores")
	public ResponseEntity<String> getAutores(){
			return ResponseEntity.ok( "Juan Pablo Casallas Ahumada - 20241578037, Componenetes grupo 301");
	}
	
	@GetMapping
	public ResponseEntity<List<Nomina>> getNomina(){
			return ResponseEntity.ok( ns.obtenerDatos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nomina> getNominaId(@PathVariable int id){
			return ns.buscarId(id)
					.map(ResponseEntity::ok)
					.orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public String postNomina(@RequestBody Empleado e) {
		return ns.calcularYGuardar(e);
	}
	
	@PutMapping
	public String putNomina(@RequestBody Nomina n) {
		ns.actualizar(n);
		return "Actualizado";
	}
	
	@DeleteMapping("/{id}")
	public String deleteNomina(@PathVariable int id) {
		ns.eliminar(id);
		return "Eliminado";
	}

}

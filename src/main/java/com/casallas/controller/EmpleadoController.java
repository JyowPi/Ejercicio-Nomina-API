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
import com.casallas.services.EmpleadoService;

@RestController
@RequestMapping("/com/empresa/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService es;
	

	@GetMapping("/autores")
	public ResponseEntity<String> getAutores(){
			return ResponseEntity.ok( "Juan Pablo Casallas Ahumada - 20241578037, Componenetes grupo 301");
	}
	
	@GetMapping
	public ResponseEntity<List<Empleado>> getEmpleado(){
			return ResponseEntity.ok( es.obtenerDatos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> getEmpleadoId(@PathVariable long id){
			return es.buscarId(id)
					.map(ResponseEntity::ok)
					.orElseGet(()->ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public String postEmpleado(@RequestBody Empleado e) {
		return es.guardar(e);
	}
	
	@PutMapping
	public String putEmpleado(@RequestBody Empleado e) {
		es.actualizar(e);
		return "Actualizado";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmpleado(@PathVariable long id) {
		es.eliminar(id);
		return "Eliminado";
	}
}

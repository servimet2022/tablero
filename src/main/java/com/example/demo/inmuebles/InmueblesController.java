package com.example.demo.inmuebles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InmueblesController {

	@Autowired
	private InmueblesServie impl;
	
	@GetMapping("/inmuebles")
	public ResponseEntity<?> getAll(){
		
		Map<String, Object> response = new HashMap<>();
		List<Inmuebles> inmuebles = null;
		
		try {
			inmuebles = impl.getAll();			
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al obtener los inmuebles de la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "Se obtienen los inmuebles");
		response.put("inmueble", inmuebles);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/inmuebles/{id}")
	public ResponseEntity<?> getInmueble(@PathVariable int id){
		
		Inmuebles inmueble = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			inmueble = impl.getOne(id);			
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al realizar la consulta a la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (inmueble == null) {
//			response.put("respuesta", "El inmueble con Id: ".concat(Integer.toString(id).concat(" no existe en la base de datos!")));
			response.put("respuesta", "Error al obtener el inmueble");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} 
		response.put("respuesta", "Se obtiene el inmueble");
		response.put("inmueble", inmueble);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	
	
	@PostMapping("/inmuebles")
	public ResponseEntity<?> saveInmueble(@RequestBody Inmuebles inmueble) {
		
		Inmuebles inmueblenew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			inmueblenew = impl.save(inmueble);		
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al guardar el inmueble en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "El inmueble ha sido creado");
		response.put("inmueble", inmueblenew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/inmuebles")
	public ResponseEntity<?> update(@RequestBody Inmuebles inmueble) {
		Inmuebles inmuebleUpdate = null;		
		Map<String, Object> response = new HashMap<>();
		try {
			inmuebleUpdate = impl.save(inmueble);		
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al guardar el inmueble en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "El inmueble se actualizo");
		response.put("inmueble", inmuebleUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/inmuebles/{id}")
	public ResponseEntity<?> deleteInmueble(@PathVariable int id){
		Map<String, Object> response = new HashMap<>();
		try {
			impl.delete(id);		
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al eliminar el inmueble de la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "El inmueble ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
}

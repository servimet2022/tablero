package com.example.demo.inmuebles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.example.demo.util.ValidationEntity;

@Service
public class InmueblesServiceImpl implements InmueblesServie{
	
	@Autowired
	private InmueblesRepo irepo;
	
	Map<String, Object> response = null;
	Inmuebles inmueble = null;


	@Override
	public Inmuebles save(Inmuebles inmueble) {
		return irepo.save(inmueble);
	}

	@Override
	public Inmuebles getOne(int id) {
		return irepo.findById(id).get();
	}
		

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> obtenerTodos(){
		response = new HashMap<>();
		List<Inmuebles> inmuebles = null;
		try {
			inmuebles = irepo.findAll();
		} catch (Exception e) {
			response.put("respuesta", "Error al obtener los inmuebles de la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "Se obtienen los inmuebles");
		response.put("inmueble", inmuebles);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> obtenerUno(int id){
		response = new HashMap<>();
		inmueble = new Inmuebles();
		
		try {
			inmueble = irepo.findById(id).orElse(null);
		}catch(DataAccessException e){
			response.put("respuesta", "Error al realizar la consulta a la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (inmueble == null) {
			response.put("respuesta", "El inmueble con Id: ".concat(Integer.toString(id).concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} 
		response.put("respuesta", "Se obtiene el inmueble");
		response.put("inmueble", inmueble);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<?> guardarInmueble(Inmuebles inmueblenew, BindingResult result){
		inmueble = new Inmuebles();
		response = new HashMap<>();
		
		if(result.hasErrors()) {
			return new ResponseEntity<Map<String, Object>>(
					ValidationEntity.validationInmueble(result)
					, HttpStatus.BAD_REQUEST);
		}
		try {
			inmueble = irepo.save(inmueblenew);		
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al guardar el inmueble en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "El inmueble ha sido creado");
		response.put("inmueble", inmueble);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@Override
	public ResponseEntity<?> actualizar(Inmuebles inmuebleUpdate, BindingResult result){
		inmueble = new Inmuebles();
		response = new HashMap<>();
		
		if(result.hasErrors()) {
			return new ResponseEntity<Map<String, Object>>(
					ValidationEntity.validationInmueble(result)
					, HttpStatus.BAD_REQUEST);
		}
		
		try {
			inmueble = irepo.save(inmuebleUpdate);		
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al actualizar el inmueble en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "El inmueble se actualizo");
		response.put("inmueble", inmueble);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}

	@Override
	public ResponseEntity<?> eliminarInmueble(int id){
		response = new HashMap<>();
		try {
			irepo.deleteById(id);
		}catch (DataAccessException e) {
			response.put("respuesta", "Error al eliminar el inmueble de la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "El inmueble ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<?> searchInmuebles(String busqueda){
		response = new HashMap<>();
		List<Inmuebles> inmuebles = null;
		try {
			inmuebles = irepo.filter(busqueda);
		} catch (DataAccessException e) {
			response.put("respuesta", "Error al obtener los inmuebles de la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("respuesta", "Se obtienen los inmuebles de busqueda");
		response.put("inmueble", inmuebles);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}


}

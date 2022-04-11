package com.example.demo.inmuebles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.ValidationEntity;


@Service
public class InmueblesServiceImpl implements InmueblesServie, InmuebleServiceExcel{
	
	private final Logger log = LoggerFactory.getLogger(InmueblesServiceImpl.class);
	
	private final static String NOMBRE_CARPETA = "uploads";
	
	@Autowired
	private InmueblesRepo irepo;
	
	Inmuebles inmueble = null;
	

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> obtenerTodos(){
		List<Inmuebles> inmuebles = null;
		try {
			inmuebles = irepo.findAll();
		} catch (Exception e) {
			return ValidationEntity.messageErrorInternalServer("Error al obtener todos los inmuebles de la base de datos");
		}
		return ValidationEntity.messageOkList("Se obtienen los inmuebles", inmuebles);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> obtenerUno(int id){
		Map<String, Object> response = new HashMap<>();
		inmueble = new Inmuebles();
		
		try {
			inmueble = irepo.findById(id).orElse(null);
			log.info("Se obtiene el Inmueble con response");
		}catch(DataAccessException e){
			return ValidationEntity.messageErrorInternalServer("Error al obtener el inmueble con id: "+id+" de la base de datos");
		}
		
		if (inmueble == null) {
			log.info("El inmueble es null");
			response.put("respuesta", "El inmueble con Id: ".concat(Integer.toString(id).concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return ValidationEntity.messageOk("Se obtiene el inmueble", inmueble);
	}

	
	@Override
	public ResponseEntity<?> guardarInmueble(Inmuebles inmueblenew, BindingResult result){
		inmueble = new Inmuebles();
		if(result.hasErrors()) {
			return ValidationEntity.validationInmueble(result,"Aparecen errores al validar y guardar inmueble" );
		}
		try {
			inmueble = irepo.save(inmueblenew);	
			log.info("Se guarda sin errores de validación el inmueble");
		} catch (DataAccessException e) {
			return ValidationEntity.messageErrorInternalServer("Error al guardar el inmueble en la base de datos");
		}
		return ValidationEntity.messageOk("El inmueble ha sido creado", inmueble);
		
	}
	
	@Override
	public ResponseEntity<?> actualizar(Inmuebles inmuebleUpdate, BindingResult result){
		inmueble = new Inmuebles();		
		if(result.hasErrors()) {
			return ValidationEntity.validationInmueble(result,"Errores al actualizar el inmueble");
		}
		
		try {
			inmueble = irepo.save(inmuebleUpdate);	
			log.info("Se actualiza sin errores el inmueble");
		} catch (DataAccessException e) {
			return ValidationEntity.messageErrorInternalServer("Error al actualizar el inmueble en la base de datos");
		}
		return ValidationEntity.messageOk("El inmueble se actualizo", inmueble);
	
	}

	@Override
	public ResponseEntity<?> eliminarInmueble(int id){		
		try {
			Inmuebles inmueble = irepo.findById(id).get(); 
			ValidationEntity.deleteArchivo(NOMBRE_CARPETA, inmueble.getArchivo());
			log.info("Se elimino archivo del inmueble: "+inmueble.getId());
			irepo.delete(inmueble);
		}catch (NoSuchElementException e) {
			log.info("Error el eliminar el inmueble: "+id+" "+e.getMessage());
			return ValidationEntity.messageErrorInternalServer("Error al eliminar el inmueble de la base de datos");
		}
		return ValidationEntity.messageOk("El inmueble ha sido eliminado", inmueble);
		
	}
	
	
	@Override
	public ResponseEntity<?> uploadImg(MultipartFile archivo, int id){
		try {
			Inmuebles inmueble = irepo.getById(id);			
			ValidationEntity.deleteArchivo(NOMBRE_CARPETA, inmueble.getArchivo());
			if(!archivo.isEmpty()) {
				inmueble.setArchivo(ValidationEntity.chargeArchivo(archivo, "uploads", id));
				irepo.save(inmueble);
			}
		} catch (EntityNotFoundException e) {
			return ValidationEntity.messageErrorInternalServer("Error al obtener el inmueble de la base de datos");
		}
		return ValidationEntity.messageOk("El archivo se cargo con éxito", inmueble);
	}


	
	
	@Override
	public ResponseEntity<Resource> showArchivo(String nombreArchivo) {
		Resource recurso = ValidationEntity.verArchivo("uploads", nombreArchivo);
		String nombre = recurso.getFilename().substring((recurso.getFilename().indexOf("_") + 1),recurso.getFilename().length());
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ nombre +"\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);

	}
	
	
	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<?> searchInmuebles(String busqueda){
		List<Inmuebles> inmuebles = null;
		try {
			inmuebles = irepo.filter(busqueda);
		} catch (DataAccessException e) {
			log.info("Error al hacer el filter: "+e.getMessage());
			return ValidationEntity.messageErrorInternalServer("Error al obtener los inmuebles de la base de datos");
		}
		return ValidationEntity.messageOkList("Se obtienen los inmuebles de busqueda", inmuebles);
	}
	
	
	
	@Override
	@Transactional(readOnly = false)
	public List<Inmuebles> filtrarExcel(String busqueda){
		return irepo.filter(busqueda);
	}
	
	
	@Override
	@Transactional(readOnly = false)
	public List<Inmuebles> allExcel(){
		return irepo.findAll();
	}

	


}

package com.example.demo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.inmuebles.Inmuebles;


public class ValidationEntity {
	
	private final static Logger log = LoggerFactory.getLogger(ValidationEntity.class);
	
	static Map<String, Object> response = null;
	
//	Este método valida si la entidad no tiene errores
	public static ResponseEntity<?> validationInmueble(BindingResult result, String mensaje){
		log.info(mensaje);
		Map<String, Object> response = new HashMap<>();		
		List<String> errores = result.getFieldErrors()
				   .stream()
				   .map( err -> "El campo: '"+err.getField()+"' "+err.getDefaultMessage())
				   .collect(Collectors.toList());
		response.put("errors", errores);
		
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}
	
//	Este método valida que exista un archivo y de ser así lo elimina
	public static void deleteArchivo(String nameFolder, String nombreArchivoAnterior) {
		if (nombreArchivoAnterior != null && nombreArchivoAnterior.length() > 0) {
			Path rutaArchivoAnterior = Paths.get(nameFolder).resolve(nombreArchivoAnterior).toAbsolutePath();
			log.info("Se elimina el archivo en la ruta:");
			log.info(rutaArchivoAnterior.toString());
			File archivoAnterior = rutaArchivoAnterior.toFile();
			if (archivoAnterior.exists() && archivoAnterior.canRead()) {
				archivoAnterior.delete();
			}
		}
	}
	
//	Este método carga un archivo en la ruta especificada
	public static String chargeArchivo(MultipartFile archivo, String nameFolder, int idUser) {
			String nombreArchivo = idUser+"_"+ archivo.getOriginalFilename().replace(" ", " ");
			Path rutaArchivo = Paths.get(nameFolder).resolve(nombreArchivo).toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
				log.info("Se cargo el archivo en la ruta:");
				log.info(rutaArchivo.toString());
			} catch (IOException e) {
				e.printStackTrace();
				log.info("Archivo muy grande");
			}
			return nombreArchivo;
	}

//	Este método manda mensaje cuando existio un error al momento de consultar, guardar, eliminar o actualizar en la base
	public static ResponseEntity<?> messageErrorInternalServer(String mensajeMap){
		response = new HashMap<>();
		log.info(mensajeMap);
		response.put("respuesta", mensajeMap);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	Este método manda mensaje de OK cuando se guardo, ejecuto o elimino un inmueble
	public static ResponseEntity<?> messageOk(String mensajeOk, Inmuebles inmueble){
		log.info(mensajeOk);
		response = new HashMap<>();
		response.put("respuesta", mensajeOk);
		response.put("inmueble", inmueble);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
//	Esté método lo que hace es que manda mensaje de OK cuando se ejecuto la opreación al obtener la lista de inmuebles
	public static ResponseEntity<?> messageOkList(String mensajeOk, List<Inmuebles> inmueble){
		log.info(mensajeOk);
		response = new HashMap<>();
		response.put("respuesta", mensajeOk);
		response.put("inmueble", inmueble);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	
}

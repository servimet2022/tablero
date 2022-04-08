package com.example.demo.inmuebles;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

public interface InmueblesServie {
	
	
	public Inmuebles save(Inmuebles inmueble);
	
	public Inmuebles getOne(int id);;
	
	
//	Estas son pruebas
	
	public ResponseEntity<?> obtenerTodos();
	
	public ResponseEntity<?> obtenerUno(int id);
	
	public ResponseEntity<?> guardarInmueble(Inmuebles inmueble, BindingResult result);   

	public ResponseEntity<?> actualizar(Inmuebles inmuebleUpdate, BindingResult result);
	
	public ResponseEntity<?> eliminarInmueble(int id);
	
	public ResponseEntity<?> searchInmuebles(String search);
	
	public ResponseEntity<?> uploadImg(MultipartFile archivo, int id);
}

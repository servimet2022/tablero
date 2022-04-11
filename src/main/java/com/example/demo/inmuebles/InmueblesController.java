package com.example.demo.inmuebles;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.ValidationEntity;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class InmueblesController {

	@Autowired
	private InmueblesServie impl;
	
	@Autowired
	private InmuebleServiceExcel serviceExcel;
	
	@GetMapping("/inmuebles")
	public ResponseEntity<?> getAll(){
		return impl.obtenerTodos();
	}
	
	
	@GetMapping("/inmuebles/{id}")
	public ResponseEntity<?> getInmueble(@PathVariable int id){
		return impl.obtenerUno(id);
	}
	

	@PostMapping("/inmuebles")
	public ResponseEntity<?> saveInmueble(@Valid @RequestBody Inmuebles inmueble, BindingResult result) {
		return impl.guardarInmueble(inmueble, result);		
	}
	
	
	@PutMapping("/inmuebles")
	public ResponseEntity<?> update(@Valid @RequestBody Inmuebles inmueble, BindingResult result) {
		return impl.actualizar(inmueble, result);
	}
	
	@DeleteMapping("/inmuebles/{id}")
	public ResponseEntity<?> deleteInmueble(@PathVariable int id){
		return impl.eliminarInmueble(id);
	}
	
	
	@PostMapping("/inmuebles/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") int id){
		return impl.uploadImg(archivo, id);
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/inmuebles/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		return (ResponseEntity<Resource>) impl.showArchivo(nombreFoto);
	}
	
	@GetMapping("/inmuebles/search/{busqueda}")
	public ResponseEntity<?> searchInmueble(@PathVariable String busqueda){
		return impl.searchInmuebles(busqueda);
	}
	
	@GetMapping("/inmuebles/excel/{filter}")
	public void descargaExcel(HttpServletResponse response,@PathVariable String filter) throws IOException {
		ValidationEntity.descargaExcel(response, serviceExcel.filtrarExcel(filter));
	}
	
	@GetMapping("/inmuebles/excel")
	public void descargaExcelSinfilter(HttpServletResponse response) throws IOException {
		ValidationEntity.descargaExcel(response, serviceExcel.allExcel());
	}
}

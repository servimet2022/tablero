package com.example.demo.inmuebles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InmueblesController {

	@Autowired
	private InmueblesServiceImpl impl;
	
	@GetMapping("/inmuebles")
	public List<Inmuebles> getAll(){
		return impl.getAll();
	}
	
	@GetMapping("/inmuebles/{id}")
	public ResponseEntity<Inmuebles> getInmueble(@PathVariable int id){
		Inmuebles inmueble = impl.getOne(id);
		return new ResponseEntity<Inmuebles>(inmueble, HttpStatus.OK);
	}
	
//	esta es una prueba
}

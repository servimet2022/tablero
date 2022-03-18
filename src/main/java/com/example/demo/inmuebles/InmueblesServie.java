package com.example.demo.inmuebles;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface InmueblesServie {
	
	public List<Inmuebles> getAll();
	
	public Inmuebles save(Inmuebles inmueble);
	
	public Inmuebles getOne(int id);
	
	public void delete(int id); 

}

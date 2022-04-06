package com.example.demo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import com.example.demo.inmuebles.Inmuebles;

public class ValidationEntity {
	
	
	public static Map<String, Object> validationInmueble(BindingResult result){
		Map<String, Object> response = new HashMap<>();
		
//		List<String> errores = result.getFieldErrors()
//		   .stream()
//		   .map( err -> "El campo: '"+err.getField()+"' "+err.getDefaultMessage())
//		   .collect(Collectors.toList());
//response.put("errors", errores);
		
		List<String> errores = result.getFieldErrors()
				   .stream()
				   .map( err -> "El campo: '"+err.getField()+"' "+err.getDefaultMessage())
				   .collect(Collectors.toList());
		response.put("errors", errores);	
		return response; 
	}
	

	
	
	
	
	
	
}

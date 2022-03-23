package com.example.demo.unidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UnidadesPrivativasController {

	@Autowired
	private UnidadesPrivativasService service;
	
	@GetMapping("/unidades")
	public List<UnidadesPrivativas> getAll(){
		return service.getAll();
	}
}

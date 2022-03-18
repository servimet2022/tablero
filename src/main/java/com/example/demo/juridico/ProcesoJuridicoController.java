package com.example.demo.juridico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProcesoJuridicoController {

	@Autowired
	private ProcesoJuridicoService service;
	
	
	@GetMapping("/juridicos")
	public List<ProcesoJuridico> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/juridicos/{id}")
	public ProcesoJuridico getOne(@PathVariable int id) {
		return service.getOne(id);
	}
	
}

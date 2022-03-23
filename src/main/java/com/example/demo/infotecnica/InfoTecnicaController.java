package com.example.demo.infotecnica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InfoTecnicaController {
	
	@Autowired
	private InfoTecnicaService service;
	
	
	@GetMapping("/info")
	public List<InfoTecnica> getAll(){
		return service.getAll();
	}

}

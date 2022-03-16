package com.example.demo.proceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProcesoController {

	@Autowired
	private ProcesoServiceImpl impl;
	
	@GetMapping("/procesos")
	public List<Proceso> getAll(){
		return impl.getAll();
	}
}

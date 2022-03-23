package com.example.demo.proceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcesoServiceImpl implements ProcesoService{
	
	@Autowired
	private ProcesoRepo irepo;
	
	@Override
	public List<Proceso> getAll() {
		return irepo.findAll();
	}
	
	
	
}

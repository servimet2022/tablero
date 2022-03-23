package com.example.demo.unidades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadesPrivativasServiceImpl implements UnidadesPrivativasService {

	@Autowired
	private UnidadesPrivativasRepo repo;
	
	@Override
	public List<UnidadesPrivativas> getAll() {
		return repo.findAll();
	} 

}

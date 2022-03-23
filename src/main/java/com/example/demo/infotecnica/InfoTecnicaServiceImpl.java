package com.example.demo.infotecnica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoTecnicaServiceImpl implements InfoTecnicaService{
	
	@Autowired
	private InfoTecnicaRepo repo;

	@Override
	public List<InfoTecnica> getAll() {
		return repo.findAll();
	}


}

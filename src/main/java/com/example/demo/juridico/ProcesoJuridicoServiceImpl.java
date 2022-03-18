package com.example.demo.juridico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcesoJuridicoServiceImpl implements ProcesoJuridicoService{
	
	@Autowired
	private ProcesoJuridicoRepo repo;

	@Override
	public List<ProcesoJuridico> getAll() {
		return repo.findAll();
	}

	@Override
	public ProcesoJuridico save(ProcesoJuridico juridico) {
		return repo.save(juridico);
	}

	@Override
	public ProcesoJuridico getOne(int id) {
		return repo.findById(id).get();
	}

}

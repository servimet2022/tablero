package com.example.demo.inmuebles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InmueblesServiceImpl implements InmueblesServie{
	
	@Autowired
	private InmueblesRepo irepo;

	@Override
	@Transactional(readOnly = true)
	public List<Inmuebles> getAll() {
		return irepo.findAll();
	}

	@Override
	public Inmuebles save(Inmuebles inmueble) {
		return irepo.save(inmueble);
	}

	@Override
	@Transactional(readOnly = true)
	public Inmuebles getOne(int id) {
		return irepo.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		irepo.deleteById(id);		
	}

	
	


}

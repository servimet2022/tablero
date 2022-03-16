package com.example.demo.inmuebles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InmueblesServiceImpl implements InmueblesServie{
	
	@Autowired
	private InmueblesRepo irepo;

	
	public List<Inmuebles> getAll() {
		return irepo.findAll();
	}
	
	public Inmuebles getOne(int id) {
		return irepo.findById(id).get();
	}

}

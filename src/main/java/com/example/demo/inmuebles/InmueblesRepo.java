package com.example.demo.inmuebles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface InmueblesRepo extends JpaRepository<Inmuebles, Integer>{

	@Procedure(name = "filter")
	public List<Inmuebles> filter(String search);
}

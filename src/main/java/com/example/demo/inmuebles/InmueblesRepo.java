package com.example.demo.inmuebles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmueblesRepo extends JpaRepository<Inmuebles, Integer>{

}

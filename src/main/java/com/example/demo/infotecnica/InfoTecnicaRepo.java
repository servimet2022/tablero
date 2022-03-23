package com.example.demo.infotecnica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTecnicaRepo extends JpaRepository<InfoTecnica, Integer>{

}

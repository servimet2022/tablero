package com.example.demo.proceso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoRepo extends JpaRepository<Proceso, Integer>{

}

package com.example.demo.juridico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoJuridicoRepo extends JpaRepository<ProcesoJuridico, Integer>{

}

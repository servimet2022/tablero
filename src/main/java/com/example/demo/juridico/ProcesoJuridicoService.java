package com.example.demo.juridico;

import java.util.List;


public interface ProcesoJuridicoService {
	
	public List<ProcesoJuridico> getAll();
	
	public ProcesoJuridico save(ProcesoJuridico juridico);
	
	public ProcesoJuridico getOne(int id);

}

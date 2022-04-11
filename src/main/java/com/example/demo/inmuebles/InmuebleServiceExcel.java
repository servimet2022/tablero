package com.example.demo.inmuebles;

import java.util.List;


public interface InmuebleServiceExcel {
	
	public List<Inmuebles> allExcel();
	
	public List<Inmuebles> filtrarExcel(String busqueda);

}

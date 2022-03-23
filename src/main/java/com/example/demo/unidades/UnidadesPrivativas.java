package com.example.demo.unidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidades_privativas")
public class UnidadesPrivativas {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "departamentos")
	private int dptos;
	
	@Column(name = "locales_comerciales")
	private int locales;
	
	@Column(name = "oficinas")
	private int oficinas;
	
	@Column(name = "cajones_estaciones")
	private int cajones;
	
	@Column(name = "bodegas")
	private int bodegas;
	
	@Column(name = "dacion_pago")
	private int dacion;
	
	@Column(name = "unidades")
	private int unidades;
	
	@Column(name = "comentarios")
	private String comentarios;
	
	@Column(name = "idinmueble")
	private int inmueble;
	
	@Column(name = "archivo")
	private String archivo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDptos() {
		return dptos;
	}

	public void setDptos(int dptos) {
		this.dptos = dptos;
	}

	public int getLocales() {
		return locales;
	}

	public void setLocales(int locales) {
		this.locales = locales;
	}

	public int getOficinas() {
		return oficinas;
	}

	public void setOficinas(int oficinas) {
		this.oficinas = oficinas;
	}

	public int getCajones() {
		return cajones;
	}

	public void setCajones(int cajones) {
		this.cajones = cajones;
	}

	public int getBodegas() {
		return bodegas;
	}

	public void setBodegas(int bodegas) {
		this.bodegas = bodegas;
	}

	public int getDacion() {
		return dacion;
	}

	public void setDacion(int dacion) {
		this.dacion = dacion;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getInmueble() {
		return inmueble;
	}

	public void setInmueble(int inmueble) {
		this.inmueble = inmueble;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	
	
	
	
	

}

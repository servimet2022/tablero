package com.example.demo.juridico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proceso_juridico")
public class ProcesoJuridico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "contrato_penalizacion")
	private String contrato;
	
	@Column(name = "fecha_regimen")
	private String fecha;
	
	@Column(name = "ind_agua")
	private String agua;
	
	@Column(name = "ind_predial")
	private String predial;
	
	@Column(name = "estatus")
	private String estatus;
	
	@Column(name = "notaria")
	private int notaria;
	
	@Column(name = "idinmueble")
	private int idinmueble;
	
	@Column(name = "archivo")
	private String archivo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getAgua() {
		return agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}

	public String getPredial() {
		return predial;
	}

	public void setPredial(String predial) {
		this.predial = predial;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getNotaria() {
		return notaria;
	}

	public void setNotaria(int notaria) {
		this.notaria = notaria;
	}

	public int getIdinmueble() {
		return idinmueble;
	}

	public void setIdinmueble(int idinmueble) {
		this.idinmueble = idinmueble;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	

}

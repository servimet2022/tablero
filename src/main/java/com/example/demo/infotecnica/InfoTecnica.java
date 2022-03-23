package com.example.demo.infotecnica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "infotecnica")
public class InfoTecnica {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fichas_firmadas")
	private String fichas;
	
	@Column(name = "valores")
	private String valores;
	
	@Column(name = "archivo")
	private String archivo;
	
	@Column(name = "idinmueble")
	private int idinmueble;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFichas() {
		return fichas;
	}

	public void setFichas(String fichas) {
		this.fichas = fichas;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public int getIdinmueble() {
		return idinmueble;
	}

	public void setIdinmueble(int idinmueble) {
		this.idinmueble = idinmueble;
	}
	
	

}

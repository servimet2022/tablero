package com.example.demo.proceso;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.inmuebles.Inmuebles;

@Entity
@Table(name = "proceso")
public class Proceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproceso;
	
	
	@Column(name = "inicio")
	private String inicio;
	
	@Column(name = "termino")
	private String termino;
	
	@Column(name = "avance")
	private int avance;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idinmueble", referencedColumnName = "id")
	private Inmuebles idinmuebles;

	public int getIdproceso() {
		return idproceso;
	}

	public void setIdproceso(int idproceso) {
		this.idproceso = idproceso;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public int getAvance() {
		return avance;
	}

	public void setAvance(int avance) {
		this.avance = avance;
	}

	public Inmuebles getIdinmuebles() {
		return idinmuebles;
	}

	public void setIdinmuebles(Inmuebles idinmuebles) {
		this.idinmuebles = idinmuebles;
	}
	
	
	
	
}

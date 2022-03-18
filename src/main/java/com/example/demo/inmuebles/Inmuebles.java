package com.example.demo.inmuebles;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.proceso.Proceso;

@Entity
@Table(name = "inmuebles")
public class Inmuebles {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name = "grupo")
	private String grupo;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "numero")
	private String numero;

	@Column(name = "alcaldia")
	private String alcaldia;
	
	@Column(name = "idinfotecnica")
	private int idinfotecnica;
	
	@Column(name = "idprocesojuridico")
	private int idprocesojuridico;
	
	@Column(name = "idredensificacion")
	private int idredensificacion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idprocesoobra", referencedColumnName = "id")
	private Proceso idprocesoobra;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAlcaldia() {
		return alcaldia;
	}

	public void setAlcaldia(String alcaldia) {
		this.alcaldia = alcaldia;
	}

	public int getIdinfotecnica() {
		return idinfotecnica;
	}

	public void setIdinfotecnica(int idinfotecnica) {
		this.idinfotecnica = idinfotecnica;
	}

	public int getIdprocesojuridico() {
		return idprocesojuridico;
	}

	public void setIdprocesojuridico(int idprocesojuridico) {
		this.idprocesojuridico = idprocesojuridico;
	}

	public int getIdredensificacion() {
		return idredensificacion;
	}

	public void setIdredensificacion(int idredensificacion) {
		this.idredensificacion = idredensificacion;
	}

	public Proceso getIdprocesoobra() {
		return idprocesoobra;
	}

	public void setIdprocesoobra(Proceso idprocesoobra) {
		this.idprocesoobra = idprocesoobra;
	}
	
	
	
	
}

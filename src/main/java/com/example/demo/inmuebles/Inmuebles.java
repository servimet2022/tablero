package com.example.demo.inmuebles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	

}

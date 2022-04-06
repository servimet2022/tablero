package com.example.demo.inmuebles;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.infotecnica.InfoTecnica;
import com.example.demo.juridico.ProcesoJuridico;
import com.example.demo.proceso.Proceso;
import com.example.demo.unidades.UnidadesPrivativas;


@Entity
@Table(name = "inmuebles")
public class Inmuebles implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int Id;
	
	@NotNull(message = "no debe ser vació")
	@Size(min = 1, max = 1, message = "debe indicar un grupo valido")
	@Column(name = "grupo")
	private String grupo;
	
	@NotNull(message = "no debe ser vació")
	@Size(min = 2, max = 100)
	@Column(name = "calle")
	private String calle;
	
	@NotNull(message = "no debe ser vació")
	@Size(min = 1, max = 10)
	@Column(name = "numero")
	private String numero;

	@NotNull(message = "no debe ser vació")
	@Size(min = 1, max = 2)
	@Column(name = "alcaldia")
	private String alcaldia;

	@Column(name = "archivo")
	private String archivo;
	
	@NotNull(message = "no debe ser vació")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idinfo_tecnica", referencedColumnName = "id")
	private InfoTecnica idinfotecnica;
	
	@NotNull(message = "no debe ser vació")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproceso_juridico", referencedColumnName = "id")
	private ProcesoJuridico idprocesojuridico;
	
	@NotNull(message = "no debe ser vació")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idunidades_privativas", referencedColumnName = "id")
	private UnidadesPrivativas idunidades;
	
	@NotNull(message = "no debe ser vació")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproceso_obra", referencedColumnName = "id")
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
	
	public InfoTecnica getIdinfotecnica() {
		return idinfotecnica;
	}

	public void setIdinfotecnica(InfoTecnica idinfotecnica) {
		this.idinfotecnica = idinfotecnica;
	}

	public ProcesoJuridico getIdprocesojuridico() {
		return idprocesojuridico;
	}

	public void setIdprocesojuridico(ProcesoJuridico idprocesojuridico) {
		this.idprocesojuridico = idprocesojuridico;
	}

	public UnidadesPrivativas getIdunidades() {
		return idunidades;
	}

	public void setIdunidades(UnidadesPrivativas idunidades) {
		this.idunidades = idunidades;
	}

	public Proceso getIdprocesoobra() {
		return idprocesoobra;
	}

	public void setIdprocesoobra(Proceso idprocesoobra) {
		this.idprocesoobra = idprocesoobra;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	@Override
	public String toString() {
		return "Inmuebles [Id=" + Id + ", grupo=" + grupo + ", calle=" + calle + ", numero=" + numero + ", alcaldia="
				+ alcaldia + ", archivo=" + archivo + ", idinfotecnica=" + idinfotecnica + ", idprocesojuridico="
				+ idprocesojuridico + ", idunidades=" + idunidades + ", idprocesoobra=" + idprocesoobra + "]";
	}

	

		
	
	
}

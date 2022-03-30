package com.example.demo.inmuebles;

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
public class Inmuebles{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int Id;
	
	@NotNull(message = "no puede estar vació")
	@Size(min = 1, max = 1, message = "debe contener información")
	@Column(name = "grupo")
	private String grupo;
	
	@NotNull
	@Size(min = 2, max = 100)
	@Column(name = "calle")
	private String calle;
	
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "numero")
	private String numero;

	@NotNull
	@Size(min = 1, max = 2)
	@Column(name = "alcaldia")
	private String alcaldia;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idinfo_tecnica", referencedColumnName = "id")
	private InfoTecnica idinfotecnica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproceso_juridico", referencedColumnName = "id")
	private ProcesoJuridico idprocesojuridico;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idunidades_privativas", referencedColumnName = "id")
	private UnidadesPrivativas unidades;
	
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

	public UnidadesPrivativas getUnidades() {
		return unidades;
	}

	public void setUnidades(UnidadesPrivativas unidades) {
		this.unidades = unidades;
	}

	public Proceso getIdprocesoobra() {
		return idprocesoobra;
	}

	public void setIdprocesoobra(Proceso idprocesoobra) {
		this.idprocesoobra = idprocesoobra;
	}

	@Override
	public String toString() {
		return "Inmuebles [Id=" + Id + ", grupo=" + grupo + ", calle=" + calle + ", numero=" + numero + ", alcaldia="
				+ alcaldia + ", idinfotecnica=" + idinfotecnica + ", idprocesojuridico=" + idprocesojuridico
				+ ", unidades=" + unidades + ", idprocesoobra=" + idprocesoobra + "]";
	}

		
	
	
}

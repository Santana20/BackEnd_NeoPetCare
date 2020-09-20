package com.neopetcare.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Vacuna")
public class Vacuna 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVacuna;
	private String nombreVacuna;
	//FK
	//Tipo tipoVacuna;
	
	@OneToMany(mappedBy = "vacuna", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RegistroVacuna> registro_vacunas;
	
	@ManyToOne
	@JoinColumn(name = "TipoMascota")
	@JsonIgnore
	private TipoMascota tipomascota;

	public Long getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(Long idVacuna) {
		this.idVacuna = idVacuna;
	}

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	public List<RegistroVacuna> getRegistro_vacunas() {
		return registro_vacunas;
	}

	public void setRegistro_vacunas(List<RegistroVacuna> registro_vacunas) {
		this.registro_vacunas = registro_vacunas;
	}

	public TipoMascota getTipomascota() {
		return tipomascota;
	}

	public void setTipomascota(TipoMascota tipomascota) {
		this.tipomascota = tipomascota;
	}
	
	
}

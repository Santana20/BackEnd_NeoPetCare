package com.neopetcare.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="RegistroVacuna")
public class RegistroVacuna 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegistroVacuna;
	
	private Date FechaRegistro;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "Mascota")
	@JsonIgnore
	private Mascota mascota;
	
	@ManyToOne
	@JoinColumn(name = "Vacuna")
	@JsonIgnore
	private Vacuna vacuna;

	public Long getIdRegistroVacuna() {
		return idRegistroVacuna;
	}

	public void setIdRegistroVacuna(Long idRegistroVacuna) {
		this.idRegistroVacuna = idRegistroVacuna;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
	
	
}

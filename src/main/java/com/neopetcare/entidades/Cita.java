package com.neopetcare.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Cita")
public class Cita 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita;
	
//	@ManyToOne
//	@JoinColumn(name = "Veterinario")
//	@JsonIgnore
//	private Veterinario veterinario;

//	@ManyToOne
//	@JoinColumn(name = "Mascota")
//	@JsonIgnore
//	private Mascota mascota;
	
	private Date fecha;
	private Date hora;
	private Boolean estado;
	
	
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
}
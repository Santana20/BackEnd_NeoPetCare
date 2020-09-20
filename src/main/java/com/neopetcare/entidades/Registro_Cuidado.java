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
@Table(name ="Registro_Cuidado")
public class Registro_Cuidado 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegistro_Cuidado;
	
	@ManyToOne
	@JoinColumn(name = "Mascota")
	@JsonIgnore
	private Mascota mascota;

	@ManyToOne
	@JoinColumn(name = "Cuidado")
	@JsonIgnore
	private Cuidado cuidado;
	
	private Date fecha;
	private Date hora;
	
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public Cuidado getCuidado() {
		return cuidado;
	}
	public void setCuidado(Cuidado cuidado) {
		this.cuidado = cuidado;
	}
	
	public Long getIdRegistro_Cuidado() {
		return idRegistro_Cuidado;
	}
	public void setIdRegistro_Cuidado(Long idRegistro_Cuidado) {
		this.idRegistro_Cuidado = idRegistro_Cuidado;
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

	
}
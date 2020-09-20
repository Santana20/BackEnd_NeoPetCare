package com.neopetcare.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Registro_Cuidado")
public class Registro_Cuidado 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegistro_Cuidado;
	
//	@ManyToOne
//	@JoinColumn(name = "Mascota")
//	@JsonIgnore
//	private Mascota mascota;

//	@ManyToOne
//	@JoinColumn(name = "Cuidado")
//	@JsonIgnore
//	private Cuidado cuidado;
	
	private Date fecha;
	private Date hora;
	
	
	public int getIdRegistro_Cuidado() {
		return idRegistro_Cuidado;
	}
	public void setIdRegistro_Cuidado(int idRegistro_Cuidado) {
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
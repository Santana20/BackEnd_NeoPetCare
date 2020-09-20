package com.neopetcare.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Cuidado")
public class Cuidado 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuidado;
	
	private String nombre;

	public int getIdCuidado() {
		return idCuidado;
	}

	public void setIdCuidado(int idCuidado) {
		this.idCuidado = idCuidado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
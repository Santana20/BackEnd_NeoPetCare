package com.neopetcare.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vacuna")
public class Vacuna 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVacuna;
	private String nombreVacuna;
	//FK
	//Tipo tipoVacuna;
}

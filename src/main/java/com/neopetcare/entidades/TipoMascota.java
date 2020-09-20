package com.neopetcare.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoMascota")
public class TipoMascota
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;
	private String nombreTipo;
}

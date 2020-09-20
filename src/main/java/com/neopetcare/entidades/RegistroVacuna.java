package com.neopetcare.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RegistroVacuna")
public class RegistroVacuna 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegistroVacuna;
	
	private Date FechaRegistro;
	private boolean status;
}

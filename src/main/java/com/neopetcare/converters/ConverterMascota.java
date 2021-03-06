package com.neopetcare.converters;

import com.neopetcare.entidades.Mascota;
import com.neopetcare.entidades.TipoMascota;

public class ConverterMascota
{
	private Long idMascota;
	private String nombre;
	private int edad;
	private double peso;
	private TipoMascota tipomascota;
	private Long idtipomascota;
	
	public Long getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public TipoMascota getTipomascota() {
		return tipomascota;
	}
	public void setTipomascota(TipoMascota tipomascota) {
		this.tipomascota = tipomascota;
	}
	public Long getIdtipomascota() {
		return idtipomascota;
	}
	public void setIdtipomascota(Long idtipomascota) {
		this.idtipomascota = idtipomascota;
	}
	
	public Mascota getMascota()
	{
		Mascota m = new Mascota();
		
		m.setNombre(this.nombre);
		m.setEdad(this.edad);
		m.setPeso(this.peso);
		return m;
	}
	
}

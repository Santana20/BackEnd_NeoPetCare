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
@Table(name="Mascota")
public class Mascota 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMascota;
	
	private String Nombre;
	private int edad;
	private int peso;
	//FK
	//Usuario dueño;
	//TipoMascota tipo;
	
	@OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Registro_Cuidado> registro_cuidados;
	
	@OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	@OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RegistroVacuna> registro_vacunas;
	
	@ManyToOne
	@JoinColumn(name = "Usuario")
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "TipoMascota")
	@JsonIgnore
	private TipoMascota tipomascota;
	
	
	
	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public List<Registro_Cuidado> getRegistro_cuidados() {
		return registro_cuidados;
	}

	public void setRegistro_cuidados(List<Registro_Cuidado> registro_cuidados) {
		this.registro_cuidados = registro_cuidados;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public List<RegistroVacuna> getRegistro_vacunas() {
		return registro_vacunas;
	}

	public void setRegistro_vacunas(List<RegistroVacuna> registro_vacunas) {
		this.registro_vacunas = registro_vacunas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoMascota getTipomascota() {
		return tipomascota;
	}

	public void setTipomascota(TipoMascota tipomascota) {
		this.tipomascota = tipomascota;
	}
	
	
}

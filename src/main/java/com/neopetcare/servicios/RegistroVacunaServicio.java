package com.neopetcare.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.entidades.Mascota;
import com.neopetcare.entidades.VacunaMascota;
import com.neopetcare.repositorios.MascotaRepositorio;
import com.neopetcare.repositorios.VacunaMascotaRepositorio;

@Service
public class RegistroVacunaServicio 
{
	@Autowired
	private VacunaMascotaRepositorio repositorioVacunaMascota;
	
	@Autowired
	private MascotaRepositorio repositorioMascota;
	
	//REGISTRAR VACUNA DE UNA MASCOTA
	public void registrarVacunamascota(Long idMascota, VacunaMascota vm) throws Exception
	{
		Mascota m = repositorioMascota.encontrarMascotaporId(idMascota);
		if ( m == null ) throw new Exception("Mascota no encontrada.");
		
		vm.setMascota(m);
		repositorioVacunaMascota.save(vm);
	}
	
	//LISTAR VACUNAS DE UNA MASCOTA
	public List<VacunaMascota> listarVacunasdeMascota(Long idMascota)
	{
		return repositorioVacunaMascota.listarVacunasdeMascota(idMascota);
	}
}

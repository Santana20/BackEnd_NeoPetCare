package com.neopetcare.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.entidades.Mascota;
import com.neopetcare.entidades.Vacuna;
import com.neopetcare.entidades.VacunaMascota;
import com.neopetcare.repositorios.MascotaRepositorio;
import com.neopetcare.repositorios.VacunaMascotaRepositorio;

@Service
public class VacunaMascotaServicio 
{
	@Autowired
	private VacunaMascotaRepositorio repositorioVacunaMascota;
	
	@Autowired
	private MascotaRepositorio repositorioMascota;
	
	@Autowired
	private VacunaServicio servicioVacuna;
	
	//REGISTRAR VACUNA DE UNA MASCOTA
	public void registrarVacunaMascota(Long idMascota, Long idVacuna, VacunaMascota vm) throws Exception
	{
		Mascota m = repositorioMascota.encontrarMascotaporId(idMascota);
		if ( m == null ) throw new Exception("Mascota no encontrada.");
		Vacuna v = servicioVacuna.obtenerVacuna(idVacuna);
		
		if ( m.getTipomascota().getIdTipo() != v.getTipomascota().getIdTipo() )
			throw new Exception("El tipo de la vacuna y la mascota no son iguales");
		vm.setMascota(m);
		vm.setVacuna(v);
		repositorioVacunaMascota.save(vm);
		return;
	}
	
	//OBTENER VACUNA DE LA MASCOTA
	private VacunaMascota obtenerVacunaMascota(Long cod) throws Exception
	{
		VacunaMascota vm = repositorioVacunaMascota.encontrarVacunaMascotaporId(cod);
		if ( vm == null ) throw new Exception( "Vacuna de la mascota no encontrada." );
		return vm;
	}
	
	//ACTUALIZAR ESTADO DE LA VACUNA DE LA MASCOTA
	public void actualizarEstadoVacunaMascota(Long idVacunaMascota) throws Exception
	{
		VacunaMascota vm = obtenerVacunaMascota(idVacunaMascota);
		
		vm.setStatus(true);
		vm.setFechaVacunaRealizada(new Date());
		repositorioVacunaMascota.save(vm);
		return;
	}
	
	//LISTAR VACUNAS DE UNA MASCOTA
	public List<VacunaMascota> listarVacunasdeMascota(Long idMascota)
	{
		return repositorioVacunaMascota.listarVacunasdeMascota(idMascota);
	}
}

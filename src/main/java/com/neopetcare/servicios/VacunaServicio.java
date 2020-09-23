package com.neopetcare.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.entidades.Vacuna;
import com.neopetcare.repositorios.VacunaRepositorio;

@Service
public class VacunaServicio
{
	@Autowired
	private VacunaRepositorio RepositorioVacuna;
	
	//REGISTRO DE VACUNA
	public void registrarVacuna(Vacuna vacuna)
	{
		RepositorioVacuna.save(vacuna);
	}
	
	//OBTENER CUIDADO
	public Vacuna obtenerVacuna(Long cod) throws Exception
	{
		Vacuna v = RepositorioVacuna.encontrarVacunaporId(cod);
		if ( v == null ) throw new Exception( "Vacuna no encontrada." );
		return v;
	}
	
	//ACTUALIZAR CUIDADO
	public void actualizarCuidado(Vacuna vacuna) throws Exception
	{
		Vacuna v = obtenerVacuna(vacuna.getIdVacuna());
		
		if ( vacuna.getNombreVacuna() != null ) v.setNombreVacuna(vacuna.getNombreVacuna());
		if ( vacuna.getTipomascota() != null ) v.setTipomascota(vacuna.getTipomascota());
		RepositorioVacuna.save(v);
		return;
	}
	
	//ELIMINAR CUIDADO
	public void eliminarVacuna(Long codigo) throws Exception
	{
		Vacuna c = obtenerVacuna(codigo);
		
		RepositorioVacuna.delete(c);
	}
	
	//LISTAR TODOS LOS CUIDADOS
	public List<Vacuna> listarCuidados()
	{
		return RepositorioVacuna.findAll();
	}
	
	//LISTAR VACUNAS POR TIPOMASCOTA
	public List<Vacuna> listarVacunaporTipo(Long idTipoMascota)
	{
		return RepositorioVacuna.listarVacunaporTipo(idTipoMascota);
	}
}

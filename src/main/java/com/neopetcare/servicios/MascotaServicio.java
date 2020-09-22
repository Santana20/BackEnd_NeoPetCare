package com.neopetcare.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.entidades.Mascota;
import com.neopetcare.repositorios.MascotaRepositorio;
import com.sun.el.stream.Optional;

@Service
public class MascotaServicio
{
	@Autowired
	private MascotaRepositorio RepositorioMascota;
	
	//REGISTRAR MASCOTA
	public void registrarMascota(Long codUsuario, Mascota mascota)
	{
		RepositorioMascota.save(mascota);
	}
	
	//OBTENER MASCOTA
	public Mascota obtenerMascota(Long cod) throws Exception
	{
		Mascota m = RepositorioMascota.encontrarMascotaporId(cod);
		if ( m == null ) throw new Exception( "Mascota no encontrada." );
		return m;
	}
	
	//ACTUALIZAR MASCOTA
	public void actualizarMascota(Mascota mascota) throws Exception
	{
		Mascota m = obtenerMascota(mascota.getIdMascota());
		
		if ( mascota.getNombre() != null ) m.setNombre(mascota.getNombre());
		
		if ( mascota.getEdad() != 0 ) m.setEdad(mascota.getEdad());
		
		if ( mascota.getPeso() != 0.0 ) m.setPeso(mascota.getPeso());
		
		if ( mascota.getTipomascota() != null )
		{
			m.setTipomascota(mascota.getTipomascota());
		}
		
		RepositorioMascota.save(m);
		return;
	}
	
	//ELIMINAR MASCOTA
	public void eliminarMascota(Long codigo) throws Exception
	{
		Mascota m = obtenerMascota(codigo);
		
		RepositorioMascota.delete(m);
	}
	
	//LISTAR TODAS LAS MASCOTAS
	public List<Mascota> listarMascotas()
	{
		return RepositorioMascota.findAll();
	}
	
	//LISTAR MASCOTAS POR USUARIO
	public List<Mascota> listarMascotasporUsuario(Long idUsuario)
	{
		return RepositorioMascota.obtenerMascotaporidUsuario(idUsuario);
	}
}

package com.neopetcare.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.entidades.Cuidado;
import com.neopetcare.entidades.Mascota;
import com.neopetcare.entidades.RegistroCuidado;
import com.neopetcare.entidades.VacunaMascota;
import com.neopetcare.repositorios.RegistroCuidadoRepositorio;
import com.neopetcare.repositorios.CuidadoRepositorio;
import com.neopetcare.repositorios.MascotaRepositorio;

@Service
public class RegistroCuidadoServicio
{
	@Autowired
	private RegistroCuidadoRepositorio RepositorioRegistroCuidado;
	@Autowired
	private MascotaRepositorio RepositorioMascota;
	@Autowired
	private CuidadoRepositorio RepositorioCuidado;
	
	//REGISTRAR REGISTRO CUIDADO
	public void registrarRegistroCuidado(Long idMascota, Long idCuidado, RegistroCuidado registroCuidado) throws Exception
	{
		Mascota m = RepositorioMascota.encontrarMascotaporId(idMascota);
		if ( m == null ) throw new Exception("Mascota no encontrada.");
		registroCuidado.setMascota(m);
		
		Cuidado c = RepositorioCuidado.encontrarCuidadoporId(idCuidado);
		if ( c == null ) throw new Exception("Cuidado no encontrado.");
		registroCuidado.setCuidado(c);
		
		RepositorioRegistroCuidado.save(registroCuidado);
	}
	
	//OBTENER REGISTRO CUIDADO
	public RegistroCuidado obtenerRegistroCuidado(Long cod) throws Exception
	{
		RegistroCuidado h = RepositorioRegistroCuidado.encontrarRegistroCuidadoporId(cod);
		if ( h == null ) throw new Exception( "Registro de cuidado no encontrado." );
		return h;
	}
	
	//ACTUALIZAR REGISTRO CUIDADO
	public void actualizarRegistroCuidado(RegistroCuidado registroCuidado) throws Exception
	{
		RegistroCuidado h = obtenerRegistroCuidado(registroCuidado.getIdRegistroCuidado());
		
		if ( registroCuidado.getFecha() != null ) h.setFecha(registroCuidado.getFecha());

		RepositorioRegistroCuidado.save(h);
		return;
	}
	
	//ELIMINAR REGISTRO CUIDADO
	public void eliminarRegistroCuidado(Long codigo) throws Exception
	{
		RegistroCuidado h = obtenerRegistroCuidado(codigo);
		
		RepositorioRegistroCuidado.delete(h);
	}
	
	//LISTAR TODOS LOS REGISTROS CUIDADO
	public List<RegistroCuidado> listarRegistroCuidado()
	{
		return RepositorioRegistroCuidado.findAll();
	}
	
	//LISTAR TODOS LOS REGISTROS CUIDADO POR MASCOTA
	public List<RegistroCuidado> listarRegistroCuidadoMascota(Long idMascota)
	{
		return RepositorioRegistroCuidado.listarCuidadoMascota(idMascota);
	}
	
}
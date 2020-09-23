package com.neopetcare.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.entidades.RegistroCuidado;
import com.neopetcare.repositorios.RegistroCuidadoRepositorio;

@Service
public class RegistroCuidadoServicio
{
	@Autowired
	private RegistroCuidadoRepositorio RepositorioRegistroCuidado;
	
	//REGISTRAR HORARIO
	public void registrarRegistroCuidado(RegistroCuidado registroCuidado)
	{
		RepositorioRegistroCuidado.save(registroCuidado);
	}
	
	//OBTENER HORARIO
	public RegistroCuidado obtenerRegistroCuidado(Long cod) throws Exception
	{
		RegistroCuidado h = RepositorioRegistroCuidado.encontrarRegistroCuidadoporId(cod);
		if ( h == null ) throw new Exception( "Registro de cuidado no encontrado." );
		return h;
	}
	
	//ACTUALIZAR HORARIO
	public void actualizarRegistroCuidado(RegistroCuidado registroCuidado) throws Exception
	{
		RegistroCuidado h = obtenerRegistroCuidado(registroCuidado.getIdRegistroCuidado());
		
		if ( registroCuidado.getFecha() != null ) h.setFecha(registroCuidado.getFecha());
		if ( registroCuidado.getHora() != null ) h.setHora(registroCuidado.getHora());

		RepositorioRegistroCuidado.save(h);
		return;
	}
	
	//ELIMINAR HORARIO
	public void eliminarRegistroCuidado(Long codigo) throws Exception
	{
		RegistroCuidado h = obtenerRegistroCuidado(codigo);
		
		RepositorioRegistroCuidado.delete(h);
	}
	
	//LISTAR TODOS LOS HORARIOS
	public List<RegistroCuidado> listarRegistroCuidado()
	{
		return RepositorioRegistroCuidado.findAll();
	}
	
}
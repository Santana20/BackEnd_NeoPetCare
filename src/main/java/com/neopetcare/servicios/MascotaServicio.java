package com.neopetcare.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.converters.ConverterMascota;
import com.neopetcare.entidades.Mascota;
import com.neopetcare.entidades.TipoMascota;
import com.neopetcare.entidades.Usuario;
import com.neopetcare.repositorios.MascotaRepositorio;

@Service
public class MascotaServicio
{
	@Autowired
	private MascotaRepositorio RepositorioMascota;
	
	@Autowired
	private UsuarioServicio servicioUsuario;
	
	@Autowired
	private TipoMascotaServicio servicioTipoMascota;
	
	//REGISTRAR MASCOTA
	public void registrarMascota(Long codUsuario, ConverterMascota mascota) throws Exception
	{
		Usuario u = servicioUsuario.obtenerUsuario(codUsuario);
		
		TipoMascota tm = servicioTipoMascota.obtenerTipoMascota(mascota.getIdtipomascota());
		
		Mascota m = mascota.getMascota();
		m.setUsuario(u);
		m.setTipomascota(tm);
		RepositorioMascota.save(m);
		return;
	}
	
	//OBTENER MASCOTA
	public Mascota obtenerMascota(Long cod) throws Exception
	{
		Mascota m = RepositorioMascota.encontrarMascotaporId(cod);
		if ( m == null ) throw new Exception( "Mascota no encontrada." );
		return m;
	}
	
	//ACTUALIZAR MASCOTA
	public void actualizarMascota(ConverterMascota mascota) throws Exception
	{
		
		Mascota m = obtenerMascota(mascota.getIdMascota());
		
		if ( mascota.getNombre() != null ) m.setNombre(mascota.getNombre());
		
		if ( mascota.getEdad() != 0 ) m.setEdad(mascota.getEdad());
		
		if ( mascota.getPeso() != 0.0 ) m.setPeso(mascota.getPeso());
		
		if ( mascota.getIdtipomascota() != null && mascota.getIdtipomascota() != m.getTipomascota().getIdTipo() )
		{
			TipoMascota tm = servicioTipoMascota.obtenerTipoMascota(mascota.getIdtipomascota());
			m.setTipomascota(tm);
		}
		
		RepositorioMascota.save(m);
		return;
	}
	
	//ELIMINAR MASCOTA
	public void eliminarMascota(Long codigo) throws Exception
	{
		Mascota m = obtenerMascota(codigo);
		
		RepositorioMascota.delete(m);
		return;
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

package com.neopetcare.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neopetcare.entidades.Usuario;
import com.neopetcare.repositorios.UsuarioRepositorio;


@Service
public class UsuarioServicio 
{
	@Autowired
	private UsuarioRepositorio RepositorioUsuario;
	
	//OBTENER USUARIO
	public Usuario obtenerUsuario(Long cod) throws Exception
	{
		Usuario u = RepositorioUsuario.encontrarUsuarioporId(cod);
		if ( u == null ) throw new Exception( "Usuario no encontrado." );
		return u;
	}
}

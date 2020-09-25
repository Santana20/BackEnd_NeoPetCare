package com.neopetcare.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neopetcare.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> 
{
	@Query( "Select v from Usuario v where v.idUsuario = :idUsuario" )
	Usuario encontrarUsuarioporId( @Param("idUsuario") Long idUsuario );
}

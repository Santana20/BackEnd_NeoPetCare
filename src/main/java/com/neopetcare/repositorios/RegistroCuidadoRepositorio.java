package com.neopetcare.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neopetcare.entidades.RegistroCuidado;

public interface RegistroCuidadoRepositorio extends JpaRepository<RegistroCuidado, Long> 
{

	@Query( "Select r from RegistroCuidado r where r.idRegistroCuidado = :cod" )
	RegistroCuidado encontrarRegistroCuidadoporId( @Param("cod") Long cod );
	
}

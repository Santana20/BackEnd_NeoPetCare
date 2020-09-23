package com.neopetcare.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neopetcare.entidades.Horario;

public interface HorarioRepositorio extends JpaRepository<Horario, Long> 
{

	@Query( "Select h from Horario h where h.idHorario = :cod" )
	Horario encontrarHorarioporId( @Param("cod") Long cod );
	
}

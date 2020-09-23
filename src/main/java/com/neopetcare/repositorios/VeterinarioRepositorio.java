package com.neopetcare.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neopetcare.entidades.Veterinario;

public interface VeterinarioRepositorio extends JpaRepository<Veterinario, Long> 
{
	@Query( "Select v from Veterinario v where v.idVeterinario = :cod" )
	Veterinario encontrarVeterinarioporId( @Param("cod") Long cod );
	
}

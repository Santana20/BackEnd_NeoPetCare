package com.neopetcare.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neopetcare.entidades.TipoMascota;

public interface TipoMascotaRepositorio extends JpaRepository<TipoMascota, Long>
{
	@Query( "Select v from TipoMascota v where v.idTipo = :idTipo" )
	TipoMascota encontrarTipoMascotaporId( @Param("idTipo") Long idTipo );
}

package com.neopetcare.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neopetcare.entidades.TipoMascota;

public interface TipoMascotaRepositorio extends JpaRepository<TipoMascota, Long>
{

}

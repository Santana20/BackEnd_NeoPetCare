package com.neopetcare.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neopetcare.entidades.Vacuna;

public interface VacunaRepositorio extends JpaRepository<Vacuna, Long> 
{

}

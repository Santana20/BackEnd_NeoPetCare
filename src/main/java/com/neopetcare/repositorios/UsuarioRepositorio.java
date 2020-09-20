package com.neopetcare.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neopetcare.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> 
{

}

package com.cristobal_aravena.login_register.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristobal_aravena.login_register.modelos.Usuario;

import java.util.Optional;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    boolean existsByNombreUsuario(String nombreUsuario);
    
    boolean existsByCorreo(String correo);
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    Optional<Usuario> findByCorreo(String correo);
}


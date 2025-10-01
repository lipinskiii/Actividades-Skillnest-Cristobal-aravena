package com.cristobal_aravena.login_register.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristobal_aravena.login_register.modelos.Usuario;

import java.util.Optional;
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    boolean existsByNombreUsuario(String nombreUsuario);
    
    boolean existsByCorreo(String correo);
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    Optional<Usuario> findByCorreo(String correo);
}


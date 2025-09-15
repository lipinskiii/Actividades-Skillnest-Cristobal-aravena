package com.cristobal_aravena.mostrar_canciones.repositorios;

import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositorioCanciones extends JpaRepository<Cancion, Long> {
    
    
    List<Cancion> findAll();
}
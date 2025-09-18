package com.cristobal_aravena.mostrar_canciones.repositorios;

import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    
    
    List<Cancion> findAll();


    void deleteById(Long id);
}
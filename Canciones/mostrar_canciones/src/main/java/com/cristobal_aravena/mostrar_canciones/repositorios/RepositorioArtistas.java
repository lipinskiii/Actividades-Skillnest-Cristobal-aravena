package com.cristobal_aravena.mostrar_canciones.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristobal_aravena.mostrar_canciones.modelos.Artista;


@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{
    
    
    List<Artista> findAll();
}

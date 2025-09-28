package com.cristobal_aravena.mostrar_canciones.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristobal_aravena.mostrar_canciones.modelos.Artista;

import org.springframework.lang.NonNull;


@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{
    
    
    @NonNull
    List<Artista> findAll();
}

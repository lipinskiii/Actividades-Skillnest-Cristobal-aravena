package com.cristobal_aravena.mostrar_canciones.servicios;

import org.springframework.stereotype.Service;
import com.cristobal_aravena.mostrar_canciones.modelos.Artista;
import com.cristobal_aravena.mostrar_canciones.repositorios.RepositorioArtistas;
import com.cristobal_aravena.mostrar_canciones.repositorios.RepositorioCanciones;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioArtistas {
    @Autowired
    private RepositorioArtistas RepositorioArtistas;
    
    public List<Artista> obtenerTodosLosArtistas(){
        return RepositorioArtistas.findAll();
    }
    
    public Artista obtenerArtistaPorId(Long id){
Optional<Artista> artistaOptional = RepositorioArtistas.findById(id);
        return artistaOptional.orElse(null);
    }
    public Artista agregarArtista(Artista artista){
        return RepositorioArtistas.save(artista);
    }

}   


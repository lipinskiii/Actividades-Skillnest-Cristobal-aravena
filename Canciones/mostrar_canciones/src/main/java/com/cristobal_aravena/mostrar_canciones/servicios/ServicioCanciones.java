package com.cristobal_aravena.mostrar_canciones.servicios;

import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;
import com.cristobal_aravena.mostrar_canciones.repositorios.RepositorioCanciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ServicioCanciones {

    @Autowired
    private RepositorioCanciones repositorioCanciones;

    public List<Cancion> obtenerTodasLasCanciones(){
        return repositorioCanciones.findAll();
    }
    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> cancionOptional = repositorioCanciones.findById(id);
        return cancionOptional.orElse(null);
    }
    public Cancion agregarCancion(Cancion cancion) {
        return repositorioCanciones.save(cancion);
    }
}


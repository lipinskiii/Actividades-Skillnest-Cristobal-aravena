package com.cristobal_aravena.peliculas_directores.controladores;

import com.cristobal_aravena.peliculas_directores.PeliculasDirectoresApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ControladorPeliculas {

    private final PeliculasDirectoresApplication peliculasDirectoresApplication;

    private static HashMap<String, String> listaPeliculas = new HashMap<>();

    
    public ControladorPeliculas(PeliculasDirectoresApplication peliculasDirectoresApplication) {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");
        listaPeliculas.put("Big Hero 6", "Don Hall");
        this.peliculasDirectoresApplication = peliculasDirectoresApplication;
    }
    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas() {
    StringBuilder Peliculas = new StringBuilder();
    for (Map.Entry<String, String> entry : listaPeliculas.entrySet()) {
        Peliculas.append(entry.getKey())
        .append("<br>");
    }
    
    return Peliculas.toString();
}
    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable String nombre){ 
        String director = listaPeliculas.get(nombre);
        if (director !=null) {
            return nombre + "-" + director;
        } else {
            return "La película no se encuentra en nuestra lista.";
        }
    }
    @GetMapping("/peliculas/director/{director}")
    public String obtenerPeliculaPorDirector(@PathVariable String director){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : listaPeliculas.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(director)) {
                sb.append(entry.getKey())
                .append("<br>");
            }
        }
        if (sb.length() == 0) {
            return "No contamos con películas con ese director en nuestra lista.";
        } else {
            return "Películas dirigidas por " + director + ":<br>" + sb.toString();
        }
    }
    
    
    
    

    
    

    
}

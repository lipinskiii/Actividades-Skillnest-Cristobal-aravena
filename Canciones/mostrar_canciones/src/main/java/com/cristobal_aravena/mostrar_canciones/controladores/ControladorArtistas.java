package com.cristobal_aravena.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

import com.cristobal_aravena.mostrar_canciones.modelos.Artista;
import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;
import com.cristobal_aravena.mostrar_canciones.repositorios.RepositorioArtistas;
import com.cristobal_aravena.mostrar_canciones.servicios.ServicioArtistas;
import com.cristobal_aravena.mostrar_canciones.servicios.ServicioCanciones;

import java.util.Date;
import java.util.List;


@RequestMapping("/artistas")
@Controller
public class ControladorArtistas {

    private final RepositorioArtistas repositorioArtistas;
    
    @Autowired
    private ServicioArtistas servicioArtistas;

    public ControladorArtistas(ServicioArtistas servicioArtistas, RepositorioArtistas repositorioArtistas) {
        this.servicioArtistas = servicioArtistas;
        this.repositorioArtistas = repositorioArtistas;
    }
    @GetMapping()
    public String mostrarArtistas(Model model) {
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("artistas", artistas );
        return "artistas";
    }
    @GetMapping("Detalle/{idArtista}")
    public String mostrarDetalleArtista(@PathVariable Long idArtista, Model model){
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        model.addAttribute("artista", artista);
        return "detalleArtista";
    }
    @GetMapping("/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        model.addAttribute("artista", new Artista());
        return "agregarArtista";
    }

    
    @PostMapping("/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, 
                                        BindingResult result, 
                                        Model model) {
        
        
        if (result.hasErrors()) {
            
            return "agregarArtista";
        }
        
        try {
            
            servicioArtistas.agregarArtista(artista);
            return "redirect:/artistas"; 
            
        } catch (Exception e) {
            
            model.addAttribute("error", "Error al guardar el artista: " + e.getMessage());
            return "agregarArtista";
        }
    }
    
    

}

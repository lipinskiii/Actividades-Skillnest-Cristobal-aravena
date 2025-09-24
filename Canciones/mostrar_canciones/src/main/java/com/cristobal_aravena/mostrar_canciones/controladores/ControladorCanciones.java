package com.cristobal_aravena.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

import com.cristobal_aravena.mostrar_canciones.servicios.ServicioArtistas;
import com.cristobal_aravena.mostrar_canciones.servicios.ServicioCanciones;

import java.util.Date;
import java.util.List;

import com.cristobal_aravena.mostrar_canciones.modelos.Artista;
import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;


@Controller
@RequestMapping("/canciones")
public class ControladorCanciones {

    @Autowired
    private ServicioArtistas servicioArtistas;

    @Autowired
    private ServicioCanciones servicioCanciones;


    public ControladorCanciones(ServicioCanciones servicioCanciones, 
                                ServicioArtistas servicioArtistas) {
        this.servicioCanciones = servicioCanciones;
        this.servicioArtistas = servicioArtistas;
    }
    @GetMapping()
    public String desplegarCanciones(Model model) {
        List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", canciones);
        return "canciones";
    }

    @GetMapping("/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    @GetMapping("formulario/agregar")
    public String mostrarFormularioNuevaCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("artistas", artistas);
        return "agregarCancion";
    }

    @PostMapping("procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute Cancion cancion, 
                                 BindingResult result, Model model, 
                                 @RequestParam("artistaId") Long artistaId) {
        
        if (result.hasErrors()) {
            List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
            model.addAttribute("artistas", artistas);
            return "agregarCancion";
        } 
        if (artistaId == null || artistaId <= 0) {
            model.addAttribute("error", "Debe seleccionar un artista");
            cargarArtistasEnModelo(model);
            return "agregarCancion";
        } 
            
        
        try {
            Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        
        if (artista == null) {
            model.addAttribute("error", "Artista no encontrado");
            cargarArtistasEnModelo(model);
            return "agregarCancion";
        }
            cancion.setArtista(artista);
            servicioCanciones.agregarCancion(cancion);
            return "redirect:/canciones";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar: " + e.getMessage());
            cargarArtistasEnModelo(model);
            model.addAttribute("cancion", cancion);
            return "agregarCancion";
    }
}
private void cargarArtistasEnModelo(Model model) {
    List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
    model.addAttribute("artistas", artistas);
}


    

    @GetMapping("/vistas/actualizacion/{idCancion}")
    public String actualizacionCancion(@PathVariable Long idCancion, Model model) {
        model.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(idCancion));
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("artistas", artistas);
        return "actualizarCancion";
    }


    @PutMapping("/actualizacion/{idCancion}")
    public String actualizarCancion(@ModelAttribute("cancion") Cancion cancionPorActualizar, @PathVariable Long idCancion, @RequestParam("artistaId") Long artistaId) {
        Cancion cancionExistente = servicioCanciones.obtenerCancionPorId(idCancion);
        
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        cancionPorActualizar.setArtista(artista);
        cancionPorActualizar.setId(idCancion);
        cancionPorActualizar.setFechaCreacion(cancionExistente.getFechaCreacion());
        cancionPorActualizar.setFechaActualizacion(new Date());
        Cancion cancionActualizada = servicioCanciones.actualizarCancion(cancionPorActualizar);

        System.out.println("este es el objeto de salida" + cancionActualizada);
        return "redirect:/canciones";
    }
    @DeleteMapping("/eliminar/{idCancion}")
    public String eliminarCancion(@PathVariable Long idCancion) {
        servicioCanciones.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }
}



package com.cristobal_aravena.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

import com.cristobal_aravena.mostrar_canciones.servicios.ServicioCanciones;
import java.util.List;


import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;
    
    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", canciones);
        return "canciones";
    }
    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    }
    
    @GetMapping("/canciones/formulario/agregar")
    public String mostrarFormularioNuevaCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "agregarCancion";
    }
    @PostMapping("/canciones/procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult result,
    Model model) {
        if (result.hasErrors()) {
            return "agregarCancion";
        }
        try {
            servicioCanciones.agregarCancion(cancion);
            return "redirect:/canciones"; 
        }catch (Exception e) {
        
        model.addAttribute("error", "Error técnico al guardar: Por favor, intenta nuevamente");
        model.addAttribute("cancion", cancion);
        return "agregarCancion";
    }
    }
    
}

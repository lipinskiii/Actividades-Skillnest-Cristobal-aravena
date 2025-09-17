package com.cristobal_aravena.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

import com.cristobal_aravena.mostrar_canciones.servicios.ServicioCanciones;
import java.util.List;


import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/canciones")
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;
    
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
        return "agregarCancion";
    }
    @PostMapping("procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult result,
    Model model) {
        try {
            servicioCanciones.agregarCancion(cancion);
            return "redirect:/canciones"; 
        } catch (ConstraintViolationException e){
            model.addAttribute("error", "Error en el formato de valores");
            model.addAttribute("cancion", cancion);
            return "agregarCancion";
        } catch (Exception e) {
            model.addAttribute("error", e);
            model.addAttribute("cancion", cancion);
            return "agregarCancion";
        } 

    }
    @PutMapping("actualizar/{idCancion}")
    public String actualizarCancion(@Valid @PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "actualizarCancion";
    } 
    
    @GetMapping("eliminar/{idCancion}")
    public String eliminarCancion(@RequestParam String param) {
        return new String();
    }
}

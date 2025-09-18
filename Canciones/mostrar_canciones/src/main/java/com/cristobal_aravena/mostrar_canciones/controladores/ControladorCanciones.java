package com.cristobal_aravena.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cristobal_aravena.mostrar_canciones.servicios.ServicioCanciones;

import java.util.Date;
import java.util.List;


import com.cristobal_aravena.mostrar_canciones.modelos.Cancion;


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
        } catch (ConstraintViolationException e) {
            model.addAttribute("error", "Error en el formato de valores");
            model.addAttribute("cancion", cancion);
            return "agregarCancion";
        } catch (Exception e) {
            model.addAttribute("error", e);
            model.addAttribute("cancion", cancion);
            return "agregarCancion";
        }

    }

    @GetMapping("/vistas/actualizacion/{idCancion}")
    public String actualizacionCancion(@PathVariable Long idCancion, Model model) {
        model.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(idCancion));
        System.out.println("este es el id que llega a la vista:  " + idCancion);
        System.out.println("este es el atributo que se enviado:  " + model.getAttribute("cancion"));

        return "actualizarCancion";
    }


    @PutMapping("/actualizacion/{idCancion}")
    public String actualizarCancion(@ModelAttribute("cancion") Cancion cancionPorActualizar, @PathVariable Long idCancion) {
        Cancion cancionExistente = servicioCanciones.obtenerCancionPorId(idCancion);

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



package com.cristobal_aravena.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping("/canciones/detalle/")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    }
    
}

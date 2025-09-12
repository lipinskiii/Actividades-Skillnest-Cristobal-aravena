package com.cristobal_aravena.explorador_recetas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;





@Controller
public class ControladoresRecetas {

    private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static HashMap<String, String[]> recetasConIngredientes = new HashMap<String, String[]>();

    public ControladoresRecetas() {
        String[] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
        recetasConIngredientes.put("Pizza", pizza);
        
        String[] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
        recetasConIngredientes.put("Espagueti", espagueti);
        
        String[] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
        recetasConIngredientes.put("Lasaña", lasaña);
    }

    @GetMapping("/recetas")
    public String obtenerTodasLasRecetas(Model modelo) {
        modelo.addAttribute("listaRecetas", listaRecetas);
        return "recetas";
    }

    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable String nombre, Model modelo) {
        System.out.println("Solicitando receta: " + nombre);
        
        if (recetasConIngredientes.containsKey(nombre)) {
            System.out.println("Receta encontrada: " + nombre);
            modelo.addAttribute("nombreReceta", nombre);
            modelo.addAttribute("ingredientes", recetasConIngredientes.get(nombre));
            return "detalleReceta";
        } else {
            System.out.println("Receta NO encontrada: " + nombre);
            modelo.addAttribute("mensajeError", "La receta no se encuentra en nuestra lista.");
            return "detalleReceta";
        }
    }
}

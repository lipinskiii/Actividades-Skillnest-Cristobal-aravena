package com.primerapagina.pagina.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    
public class Controladores {
    GetMapping("/")
    public String index(){
        return "Hola Mundo";
    }
}

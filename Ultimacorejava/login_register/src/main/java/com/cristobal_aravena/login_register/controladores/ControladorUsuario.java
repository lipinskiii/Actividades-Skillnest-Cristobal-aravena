package com.cristobal_aravena.login_register.controladores;

import com.cristobal_aravena.login_register.modelos.LoginUsuario;
import com.cristobal_aravena.login_register.modelos.Usuario;
import com.cristobal_aravena.login_register.servicios.ServicioUsuarios;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorUsuario {

  private final ServicioUsuarios servicio;

  public ControladorUsuario(ServicioUsuarios servicio){ 
    this.servicio = servicio; 
  }

  
  @ModelAttribute("usuario")
  public Usuario usuario() { 
    return new Usuario(); 
  }

    @ModelAttribute("loginUsuario")
    public LoginUsuario loginUsuario() { return new LoginUsuario(); }

  @GetMapping("/")
  public String index(Model model, @RequestParam(defaultValue="login") String tab){
    if (!model.containsAttribute("usuario"))     model.addAttribute("usuario", new Usuario());
    if (!model.containsAttribute("loginUsuario"))model.addAttribute("loginUsuario", new LoginUsuario());
    model.addAttribute("activeTab", tab);
    return "index";
  }

  @PostMapping("/procesa/registro")
  public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario usuario,
                                 BindingResult br, Model model){
    if (br.hasErrors()){
      model.addAttribute("activeTab","register");
      model.addAttribute("loginUsuario", new LoginUsuario());
      return "index";
    }
    try {
      servicio.agregarUno(usuario);
    } catch (IllegalArgumentException e){
      // mapea errores al campo correspondiente
      String msg = e.getMessage();
      if (msg.contains("usuario")) br.rejectValue("nombreUsuario","dup",msg);
      else if (msg.contains("correo")) br.rejectValue("correo","dup",msg);
      else br.rejectValue("confirmacionContrasenia","mismatch",msg);

      model.addAttribute("activeTab","register");
      model.addAttribute("loginUsuario", new LoginUsuario());
      return "index";
    }
    return "redirect:/inicio";
  }

  @PostMapping("/procesa/login")
  public String procesarLogin(@Valid @ModelAttribute("LoginUsuario") LoginUsuario login,
                              BindingResult br, Model model){
    if (br.hasErrors()){
      model.addAttribute("activeTab","login");
      model.addAttribute("usuario", new Usuario());
      return "index";
    }
    if (!servicio.autenticar(login)){
      br.rejectValue("contrasenia","auth.bad","Usuario o contraseña inválidos.");
      model.addAttribute("activeTab","login");
      model.addAttribute("usuario", new Usuario());
      return "index";
    }
    return "redirect:/inicio";
  }

  @GetMapping("/inicio")
  public String inicio(){ 
    return "inicio"; 
  }
}
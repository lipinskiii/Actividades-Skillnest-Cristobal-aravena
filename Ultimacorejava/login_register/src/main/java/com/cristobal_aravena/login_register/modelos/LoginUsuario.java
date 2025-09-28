package com.cristobal_aravena.login_register.modelos;

import jakarta.validation.constraints.NotBlank;

public class LoginUsuario {
  @NotBlank private String usernameOrEmail;
  @NotBlank private String contrasenia;

  public String getUsernameOrEmail(){ return usernameOrEmail; }
  public void setUsernameOrEmail(String v){ this.usernameOrEmail = v; }
  public String getContrasenia(){ return contrasenia; }
  public void setContrasenia(String v){ this.contrasenia = v; }
}
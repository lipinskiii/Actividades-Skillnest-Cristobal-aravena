package com.cristobal_aravena.login_register.servicios;

import com.cristobal_aravena.login_register.modelos.LoginUsuario;
import com.cristobal_aravena.login_register.modelos.Usuario;
import com.cristobal_aravena.login_register.repositorios.RepositorioUsuario;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuarios {

  private final RepositorioUsuario repo;

  public ServicioUsuarios(RepositorioUsuario repo){ this.repo = repo; }

  // Registro
  public Usuario agregarUno(Usuario u){
    if (!u.getContrasenia().equals(u.getConfirmacionContrasenia()))
      throw new IllegalArgumentException("Las contraseñas no coinciden.");

    if (repo.existsByNombreUsuario(u.getNombreUsuario()))
      throw new IllegalArgumentException("El nombre de usuario ya existe.");

    if (repo.existsByCorreo(u.getCorreo()))
      throw new IllegalArgumentException("El correo ya está registrado.");

    String hash = BCrypt.hashpw(u.getContrasenia(), BCrypt.gensalt(12));
    u.setContrasenaHash(hash);
    u.setContrasenia(null);
    u.setConfirmacionContrasenia(null);

    return repo.save(u);
  }

  // Login
  public boolean autenticar(LoginUsuario login){
    var user = repo.findByNombreUsuario(login.getUsernameOrEmail())
                   .orElseGet(() -> repo.findByCorreo(login.getUsernameOrEmail()).orElse(null));
    return user != null && BCrypt.checkpw(login.getContrasenia(), user.getContrasenaHash());
  }
}
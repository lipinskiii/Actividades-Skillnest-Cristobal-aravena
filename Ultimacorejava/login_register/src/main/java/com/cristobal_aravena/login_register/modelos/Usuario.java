package com.cristobal_aravena.login_register.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="usuarios",
  uniqueConstraints = {
    @UniqueConstraint(name="uk_usuario_username", columnNames="nombreUsuario"),
    @UniqueConstraint(name="uk_usuario_correo", columnNames="correo")
})
    public class Usuario {

        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        @NotBlank @Size(min=3, max=15)
        @Column(nullable=false, unique=true, length=15)
        private String nombreUsuario;

        @NotBlank @Email
        @Column(nullable=false, unique=true)
        private String correo;

        @NotBlank @Size(min=3, max=50)
        @Pattern(regexp="^[\\p{L}]+(?:[ '-][\\p{L}]+)*$", message="Solo letras, mínimo 3.")
        @Column(nullable=false, length=50)
        private String nombre;

        @NotBlank @Size(min=3, max=50)
        @Pattern(regexp="^[\\p{L}]+(?:[ '-][\\p{L}]+)*$", message="Solo letras, mínimo 3.")
        @Column(nullable=false, length=50)
        private String apellido;

        @NotNull @Past
        @Column(nullable=false)
        private LocalDate fechaDeNacimiento;

        
        @Column(name="contrasena_hash", nullable=false, length=60)
        private String contrasenaHash;


        @Transient
        @Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$", message="Tu contraseña debe tener una mayúscula, una minúscula, un número y mínimo 8 caracteres.")
        private String contrasenia;

        @Transient
        private String confirmacionContrasenia;

        @Column(nullable=false, updatable=false)
        private LocalDateTime fechaCreacion;

        @Column(nullable=false)
        private LocalDateTime fechaActualizacion;

        public Usuario() {}

        @PrePersist
        void onCreate(){
            var now = LocalDateTime.now();
            fechaCreacion = now;
            fechaActualizacion = now;
        }
        @PreUpdate
        void onUpdate(){ fechaActualizacion = LocalDateTime.now(); 
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public LocalDate getFechaDeNacimiento() {
            return fechaDeNacimiento;
        }

        public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
        }

        public String getContrasenaHash() {
            return contrasenaHash;
        }

        public void setContrasenaHash(String contrasenaHash) {
            this.contrasenaHash = contrasenaHash;
        }

        public String getContrasenia() {
            return contrasenia;
        }

        public void setContrasenia(String contrasenia) {
            this.contrasenia = contrasenia;
        }

        public String getConfirmacionContrasenia() {
            return confirmacionContrasenia;
        }

        public void setConfirmacionContrasenia(String confirmacionContrasenia) {
            this.confirmacionContrasenia = confirmacionContrasenia;
        }

        public LocalDateTime getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public LocalDateTime getFechaActualizacion() {
            return fechaActualizacion;
        }

        public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
        }
    
}
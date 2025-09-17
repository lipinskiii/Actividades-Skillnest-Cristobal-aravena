package com.cristobal_aravena.mostrar_canciones.modelos;

import jakarta.persistence.*;
import java.util.Date;
import jakarta.validation.constraints.Size;





@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Size(min=5, max=100, message = "El título debe tener entre 5 y 100 caracteres")
    private String titulo;

    @Size(min=3, max=20)
    private String artista;

    @Size(min=3, max=50)
    private String album;

    @Size(min=3, max=30)
    private String genero;

    @Size(min=3, max=30)
    private String idioma;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    // Constructor vacío
    public Cancion() {
    }

    @PrePersist
    protected void onCreate() {
    Date now = new Date();
    this.fechaCreacion = now;
    this.fechaActualizacion = now;
    }

    @PreUpdate
    protected void onUpdate() {
    this.fechaActualizacion = new Date();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
package com.clases;

public class ProductoElectrodomestico {
    public String Nombre;
    public Double Precio;
    public int cantidadDisponible;

    public ProductoElectrodomestico(String nombre, Double precio, int cantidadDisponible){
        this.Nombre = nombre;
        this.Precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public ProductoElectrodomestico(String nombre, Double precio){
        this(nombre, precio, 0);
    }

    public String getNombre(){
        return Nombre;
    }
    public Double getPrecio(){
        return Precio;
    }
    public int getCantidadDisponible(){
        return cantidadDisponible;
    }
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    public void setPrecio(Double precio){
        this.Precio = precio;
    }
    public void setCantidadDisponible(int cantidadDisponible){
        this.cantidadDisponible = cantidadDisponible;
    }
    public String mostrarInformacion(){
        return "Nombre: " + Nombre + ", Precio: " + Precio + ",Cantidad: " + cantidadDisponible;
    }
}